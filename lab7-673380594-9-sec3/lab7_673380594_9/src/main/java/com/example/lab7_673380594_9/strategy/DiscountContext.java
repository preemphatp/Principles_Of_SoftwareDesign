package com.example.lab7_673380594_9.strategy;

import org.springframework.stereotype.Component;

@Component
public class DiscountContext {

    private final NoDiscountStrategy noDiscountStrategy;
    private final StudentDiscountStrategy studentDiscountStrategy;
    private final SeasonalSaleStrategy seasonalSaleStrategy;

    
    public DiscountContext(NoDiscountStrategy noDiscountStrategy,
                            StudentDiscountStrategy studentDiscountStrategy,
                            SeasonalSaleStrategy seasonalSaleStrategy) {
        this.noDiscountStrategy = noDiscountStrategy;
        this.studentDiscountStrategy = studentDiscountStrategy;
        this.seasonalSaleStrategy = seasonalSaleStrategy;
    }

    public double calculatePrice(double originalPrice, String discountType) {
        DiscountStrategy strategy = switch (discountType) {
            case "STUDENT" -> studentDiscountStrategy;
            case "SEASONAL" -> seasonalSaleStrategy;
            default -> noDiscountStrategy;
        };
        return strategy.applyDiscount(originalPrice);
    }
}