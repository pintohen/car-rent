package com.example.carrent.domain.car.group;

public class CarGroupFactory {
    public static CarGroup createCarGroup(String name, String numberOfDoors, String dailyPrice, String carClassValue) {

        CarClass carClass;
        switch (carClassValue) {
            case "UTILITARIAN":
                carClass = CarClass.UTILITARIAN;
                break;
            case "LUXURY":
                carClass = CarClass.LUXURY;
                break;
            case "COMERCIAL":
                carClass = CarClass.COMERCIAL;
                break;
            default:
                throw new IllegalArgumentException("Invalid car class value: " + carClassValue);
        }


        return new CarGroup(
            Name.of(name),
            NumberOfDoors.of(numberOfDoors),
            DailyPrice.of(dailyPrice),
            carClass
        );
    }
}
