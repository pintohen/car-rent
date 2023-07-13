package com.example.carrent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarGroupDTO {
    private Long id;
    private String name;
    private Integer numberOfDoors;
    private Double dailyPrice;
    private String carClass;
}
