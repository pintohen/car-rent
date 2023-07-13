package com.example.carrent.domain.car;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class Plate implements Serializable {
    private static final String REGEX = "(([A-Z]{2}-\\d{2}-(\\d{2}|[A-Z]{2}))|(\\d{2}-(\\d{2}-[A-Z]{2}|[A-Z]{2}-\\d{2})))";

    @Column(name = "plate", unique = true)
    private String value;

    public Plate() {
    }

    private Plate(String value) {
        this.value = value;
    }

    public static Plate of(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Plate cannot be null");
        }
        if (!value.matches(REGEX)) {
            throw new IllegalArgumentException("Plate is not valid");
        }
        return new Plate(value);
    }

    public String value() {
        return value;
    }
}
