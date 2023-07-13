package com.example.carrent.repository;

import com.example.carrent.domain.car.Car;
import com.example.carrent.domain.car.Plate;
import com.example.carrent.domain.car.group.CarGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Plate> {
    Optional<Car> findByPlate(Plate plate);
    List<Car> findCarsByCarGroup(CarGroup group);
}
