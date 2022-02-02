package br.com.codenation;

import br.com.codenation.paymentmethods.PaymentMethod;
import br.com.codenation.paymentmethods.PriceStrategy;

public class BillingProcessor {

    public Double calculate(Order order) {
        try{
            PaymentMethod type = order.getPaymentMethod();
            PriceStrategy method =  type.getPaymentStrategy();
            return method.calculate(order.getPrice());
        } catch(RuntimeException err) {
            throw new RuntimeException("Payment method not implemented");
        }
    }

}