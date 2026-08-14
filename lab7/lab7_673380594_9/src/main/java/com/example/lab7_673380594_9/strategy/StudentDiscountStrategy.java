package com.example.lab7_673380594_9.strategy;

import org.springframework.stereotype.Component;

@Component
public class StudentDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * 0.90; // ลด 10%
    }
}