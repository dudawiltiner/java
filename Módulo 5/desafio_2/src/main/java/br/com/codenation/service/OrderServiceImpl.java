package br.com.codenation.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		AtomicReference<Double> result = new AtomicReference<>(0.0);

		items.forEach(item -> {
			Long productId = item.getProductId();
			Optional<Product> product = this.productRepository.findById(productId);
			Double value = product.get().getValue();
			if(product.get().getIsSale()){
				Double valueWithDescont = getDescont20Percent(value);
				result.updateAndGet(v -> v + valueWithDescont * item.getQuantity());
			} else {
				result.updateAndGet(v -> v + value * item.getQuantity());
			}
		});

		return result.get();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		Set<Product> products = new HashSet<>();
		ids.forEach(id -> {
			Optional<Product> product = this.productRepository.findById(id);
			product.ifPresent(products::add);
		});

		return products;
	}

	/**
	 * Calculate the sum of all Orders(List<OrderItem>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		AtomicReference<Double> result = new AtomicReference<>(0.0);

		orders.forEach(order -> {
			Double value = calculateOrderValue(order);
			result.updateAndGet(v -> v + value);
		});

		return result.get();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		List<Product> productsIsSaleTrue = new ArrayList<>();
		List<Product> productsIsSaleFalse = new ArrayList<>();
		Map<Boolean, List<Product>> mapProducts = new HashMap<>();

		productIds.forEach(id -> {
			Optional<Product> product = this.productRepository.findById(id);
			if(product.get().getIsSale()){
				productsIsSaleTrue.add(product.get());
			} else {
				productsIsSaleFalse.add(product.get());
			}

		});

		mapProducts.put(true, productsIsSaleTrue);
		mapProducts.put(false, productsIsSaleFalse);

		return mapProducts;
	}

	public Double getDescont20Percent(Double value) {
		return value - value*0.20;
	}
}