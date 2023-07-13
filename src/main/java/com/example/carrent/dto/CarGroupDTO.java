package com.example.carrent.dto;

import com.example.carrent.domain.car.group.CarClass;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarGroupDTO {
    private Long id;
    private String name;
    private Integer numberOfDoors;
    private Double dailyPrice;
    private CarClass carClass;
}
