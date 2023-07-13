package com.example.carrent.domain.car;

import com.example.carrent.domain.car.group.CarGroup;

public class CarFactory {
    public static Car of(String plate, String yearOfPurchase, String color, String cylinderValue, CarGroup group) {

        return new Car(
                Plate.of(plate),
                YearOfPurchase.of(yearOfPurchase),
                Color.of(color),
                CylinderValue.of(cylinderValue),
                group
        );
    }


}
