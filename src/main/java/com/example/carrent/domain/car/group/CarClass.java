package com.example.carrent.domain.car.group;

public enum CarClass {
    UTILITARIAN,
    LUXURY,
    COMERCIAL;

    public static CarClass fromString(String value) {
        switch (value) {
            case "UTILITARIAN":
                return CarClass.UTILITARIAN;
            case "LUXURY":
                return CarClass.LUXURY;
            case "COMERCIAL":
                return CarClass.COMERCIAL;
            default:
                throw new IllegalArgumentException("Invalid car class value: " + value);
        }
    }

}
