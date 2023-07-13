package com.example.carrent.domain.car;

import com.example.carrent.domain.car.group.CarGroup;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "T_CAR")
@Getter
public class Car {

    @EmbeddedId
    private Plate plate;
    private YearOfPurchase yearOfPurchase;
    private Color color;
    private CylinderValue cylinderValue;

    @ManyToOne
    @JoinColumn(name = "car_group_id")
    private CarGroup carGroup;

    public Car() {
    }

    protected Car(Plate plate, YearOfPurchase yearOfPurchase, Color color, CylinderValue cylinderValue, CarGroup carGroup) {
        this.plate = plate;
        this.yearOfPurchase = yearOfPurchase;
        this.color = color;
        this.cylinderValue = cylinderValue;
        this.carGroup = carGroup;
    }
}
