package com.ministore.util;

import com.ministore.service.discount.DiscountStrategy;
import com.ministore.service.discount.NoDiscountStrategy;
import com.ministore.service.discount.PercentageDiscountStrategy;

import java.math.BigDecimal;

public class DiscountStrategyTest {

    public static void main(String[] args) {

        BigDecimal totalPrice =
                new BigDecimal("510000");

        // Strategy 1: Không giảm giá
        DiscountStrategy noDiscount =
                new NoDiscountStrategy();

        BigDecimal discount1 =
                noDiscount.calculateDiscount(totalPrice);

        System.out.println(
                "Không giảm giá: " + discount1
        );

        // Strategy 2: Giảm 10%
        DiscountStrategy discount10Percent =
                new PercentageDiscountStrategy(
                        new BigDecimal("10")
                );

        BigDecimal discount2 =
                discount10Percent.calculateDiscount(totalPrice);

        System.out.println(
                "Giảm 10%: " + discount2
        );

        BigDecimal finalPrice =
                totalPrice.subtract(discount2);

        System.out.println(
                "Giá sau giảm: " + finalPrice
        );
    }
}