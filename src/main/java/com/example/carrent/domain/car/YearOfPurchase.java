package com.example.carrent.domain.car;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDate;

@Embeddable
@Getter
public class YearOfPurchase {
    @Column(name = "year_of_purchase", nullable = false)
    private Integer value;

    public YearOfPurchase() {
    }

    private YearOfPurchase(String value) {
        int valueAsInt;
        if(value == null) {
            throw new IllegalArgumentException("Year of purchase cannot be null");
        }

        try {
            valueAsInt = Integer.parseInt(value);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Year of purchase must be a number");
        }

        if(valueAsInt < 1900 || valueAsInt > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Year of purchase must be between 1900 this year");
        }

        this.value = valueAsInt;
    }

    public static YearOfPurchase of(String value) {
        return new YearOfPurchase(value);
    }
}
