package com.example.carrent.service;

import com.example.carrent.domain.car.Car;
import com.example.carrent.domain.car.CarFactory;
import com.example.carrent.domain.car.Plate;
import com.example.carrent.domain.car.group.CarGroup;
import com.example.carrent.dto.CarDTO;
import com.example.carrent.dto.mapper.CarMapper;
import com.example.carrent.repository.CarGroupRepository;
import com.example.carrent.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository repo;
    private final CarGroupRepository carGroupRepo;

    @Autowired
    public CarService(CarRepository repo, CarGroupRepository carGroupRepo) {
        this.repo = repo;
        this.carGroupRepo = carGroupRepo;
    }

    public List<CarDTO> findCarsByCarGroup(Long id){

        CarGroup group = carGroupRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("Car group with id " + id + " does not exist")
        );

        return CarMapper.toDTO(repo.findCarsByCarGroup(group));
    }

    public CarDTO createCar(String plate, String yearOfPurchase, String color, String cylinderValue, Long carGroupId){
        CarGroup group = carGroupRepo.findById(carGroupId).orElseThrow(
                () -> new IllegalArgumentException("Car group with id " + carGroupId + " does not exist")
        );

        Car car = CarFactory.of(plate, yearOfPurchase, color, cylinderValue, group);

        if(repo
                .findByPlate(Plate.of(plate))
                .isPresent())
            throw new IllegalArgumentException("Car with plate " + plate + " already exists");

        return CarMapper.toDTO(repo.save(car));
    }

    public List<CarDTO> findAll() {
        return CarMapper.toDTO(repo.findAll());
    }

    public CarDTO findByPlate(String plate) {
        return CarMapper.toDTO(repo.findByPlate(Plate.of(plate)).orElseThrow(
                () -> new IllegalArgumentException("Car with plate " + plate + " does not exist")
        ));
    }
}
