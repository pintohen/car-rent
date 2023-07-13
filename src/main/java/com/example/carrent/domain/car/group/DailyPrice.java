package com.example.carrent.domain.car.group;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class DailyPrice {
    @Column(name = "daily_price", nullable = false)
    private Double value;

    private DailyPrice(Double value) {
        if(value == null) {
            throw new IllegalArgumentException("Daily price cannot be null");
        }

        if(value < 0) {
            throw new IllegalArgumentException("Daily price must be a positive number");
        }

        this.value = value;
    }

    public DailyPrice() {
    }

    public static DailyPrice of(String value) {
        try {
            return new DailyPrice(Double.parseDouble(value));
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Daily price must be a number");
        }
    }
}
