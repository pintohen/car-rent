package com.example.carrent.dto.mapper;

import com.example.carrent.domain.car.Car;
import com.example.carrent.dto.CarDTO;

import java.util.List;

public class CarMapper {
    public static CarDTO toDTO(Car car) {
        return new CarDTO(
                car.getPlate().getValue(),
                car.getColor().getValue(),
                car.getCarGroup().getId()
        );
    }

    public static List<CarDTO> toDTO(List<Car> carList) {
        return carList.stream().map(CarMapper::toDTO).toList();
    }
}
