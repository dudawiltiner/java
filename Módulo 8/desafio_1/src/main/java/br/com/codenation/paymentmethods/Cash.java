package br.com.codenation.paymentmethods;

import static br.com.codenation.paymentmethods.PaymentMethod.CASH;

public class Cash implements PriceStrategy{
    @Override
    public Double calculate(Double price) {
        return price * 0.9;
    }
}
