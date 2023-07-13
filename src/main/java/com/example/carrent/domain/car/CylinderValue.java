package com.example.carrent.domain.car;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class CylinderValue {
    @Column(name = "cylinder_value", nullable = false)
    private Integer value;

    private CylinderValue(String value) {
        int valueAsInt;
        if (value == null) {
            throw new IllegalArgumentException("Cylinder value cannot be null");
        }

        try {
            valueAsInt = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cylinder value must be a number");
        }

        if (valueAsInt < 0) {
            throw new IllegalArgumentException("Cylinder value must be a positive number");
        }

        this.value = valueAsInt;
    }

    public CylinderValue() {
    }

    public static CylinderValue of(String value) {
        return new CylinderValue(value);
    }

    public Integer value() {
        return value;
    }
}
