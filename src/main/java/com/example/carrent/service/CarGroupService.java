package com.example.carrent.service;

import com.example.carrent.domain.car.group.CarClass;
import com.example.carrent.domain.car.group.CarGroup;
import com.example.carrent.domain.car.group.CarGroupFactory;
import com.example.carrent.domain.car.group.Name;
import com.example.carrent.dto.CarGroupDTO;
import com.example.carrent.dto.mapper.CarGroupMapper;
import com.example.carrent.repository.CarGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarGroupService {
    private final CarGroupRepository repo;

    @Autowired
    public CarGroupService(CarGroupRepository repo) {
        this.repo = repo;
    }

    public CarGroupDTO createCarGroup(String name, String numberOfDoors, String dailyPrice, String carClassValue) {

        CarGroup group = CarGroupFactory.createCarGroup(
            name,
            numberOfDoors,
            dailyPrice,
            carClassValue
        );

        return CarGroupMapper.toDTO(repo.save(group));
    }

    public List<CarGroupDTO> findAll() {
        return CarGroupMapper.toDTO(repo.findAll());
    }

    public CarGroupDTO findById(Long id) {
        return CarGroupMapper.toDTO(
                repo.findById(id).orElseThrow(
                        () -> new IllegalArgumentException("Car group with id: " + id + " not found")
                )
        );
    }

    public CarGroupDTO findByName(String name) {
        return CarGroupMapper.toDTO(
                repo.findByName(Name.of(name)).orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        "Car group with name: " + name + " not found")
                )
        );
    }

    public List<CarGroupDTO> findByCarClass(String carClass) {
        return CarGroupMapper.toDTO(repo.findByCarClass(CarClass.fromString(carClass)));
    }

}
