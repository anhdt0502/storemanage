package com.ministore.service.discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentageDiscountStrategy
        implements DiscountStrategy {

    private final BigDecimal discountPercent;

    public PercentageDiscountStrategy(
            BigDecimal discountPercent) {

        this.discountPercent = discountPercent;
    }

    @Override
    public BigDecimal calculateDiscount(
            BigDecimal totalPrice) {

        return totalPrice
                .multiply(discountPercent)
                .divide(
                        BigDecimal.valueOf(100),
                        2,
                        RoundingMode.HALF_UP
                );
    }
}