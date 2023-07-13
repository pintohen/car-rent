package com.example.carrent.domain.car.group;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class NumberOfDoors {
    @Column(name = "number_of_doors")
    private Integer value;

    private NumberOfDoors(Integer value) {
        if(value == null) {
            throw new IllegalArgumentException("Number of doors cannot be null");
        }

        if(value < 0) {
            throw new IllegalArgumentException("Number of doors must be a positive number");
        }

        if(value > 8) {
            throw new IllegalArgumentException("Number of doors must be less than 8");
        }

        this.value = value;
    }

    public NumberOfDoors() {
    }

    public static NumberOfDoors of(String value) {
        try {
            return new NumberOfDoors(Integer.parseInt(value));
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Number of doors must be a number");
        }
    }
}
