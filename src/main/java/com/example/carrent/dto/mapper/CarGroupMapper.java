package com.example.carrent.dto.mapper;

import com.example.carrent.domain.car.group.CarGroup;
import com.example.carrent.dto.CarGroupDTO;

import java.util.List;

public class CarGroupMapper {
    public static CarGroupDTO toDTO(CarGroup carGroup) {
        return new CarGroupDTO(
                carGroup.getId(),
                carGroup.getName().getValue(),
                carGroup.getNumberOfDoors().getValue(),
                carGroup.getDailyPrice().getValue(),
                carGroup.getCarClass()
        );
    }

    public static List<CarGroupDTO> toDTO(List<CarGroup> carGroup) {
        return carGroup.stream().map(CarGroupMapper::toDTO).toList();
    }
}
