package com.example.carrent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarDTO {
    private String plate;
    private String color;
    private Long carGroupId;
}
