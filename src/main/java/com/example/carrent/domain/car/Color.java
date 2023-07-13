package com.example.carrent.domain.car;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Color {
    @Column(name = "car_color", nullable = false)
    private String value;

    private Color(String value) {
        this.value = value;
    }

    public Color() {
    }

    public static Color of(String value) {
        return new Color(value);
    }

    public String value() {
        return value;
    }


}
