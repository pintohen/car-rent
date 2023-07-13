package com.example.carrent.domain.car.group;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Name {
    @Column(name = "car_group_name", nullable = false)
    private String value;

    private Name(String value) {
        if(value == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        if(value.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters long");
        }

        this.value = value;
    }

    public Name() {
    }

    public static Name of(String value) {
        return new Name(value);
    }
}
