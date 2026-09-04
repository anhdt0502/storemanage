package com.ministore.service.discount;

import java.math.BigDecimal;

public class NoDiscountStrategy
        implements DiscountStrategy {

    @Override
    public BigDecimal calculateDiscount(
            BigDecimal totalPrice) {

        return BigDecimal.ZERO;
    }
}