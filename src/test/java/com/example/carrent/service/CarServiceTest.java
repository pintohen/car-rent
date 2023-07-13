package com.example.carrent.service;

import com.example.carrent.domain.car.Car;
import com.example.carrent.domain.car.CarFactory;
import com.example.carrent.domain.car.Plate;
import com.example.carrent.domain.car.group.CarGroup;
import com.example.carrent.domain.car.group.CarGroupFactory;
import com.example.carrent.repository.CarGroupRepository;
import com.example.carrent.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {

    @Mock
    CarRepository repo;
    @Mock
    CarGroupRepository carGroupRepo;
    CarService svc;

    CarGroup group;
    Car car;

    @BeforeEach
    void setUp() {
        repo = mock();
        carGroupRepo = mock();
        svc = new CarService(repo, carGroupRepo);

        group = CarGroupFactory.createCarGroup(
                "name",
                "4",
                "17.5",
                "LUXURY"
        );

        car = CarFactory.of(
                "AA-11-AA",
                "2004",
                "yellow",
                "100000",
                group
        );




    }

    @Test
    void findCarsByCarGroup() {
        when(carGroupRepo.findById(1L)).thenReturn(Optional.of(group));
        when(repo.findCarsByCarGroup(group)).thenReturn(List.of(car));

        svc.findCarsByCarGroup(1L);

        verify(carGroupRepo, times(1)).findById(1L);
        verify(repo, times(1)).findCarsByCarGroup(group);
    }

    @Test
    void createCar() {
        when(carGroupRepo.findById(1L)).thenReturn(Optional.of(group));
        when(repo.save(any(Car.class))).thenReturn(car);

        svc.createCar(
                "AA-11-AA",
                "2004",
                "yellow",
                "100000",
                1L
        );

        verify(repo, times(1)).save(any(Car.class));
    }

    @Test
    void findAll() {
        when(repo.findAll()).thenReturn(List.of(car));

        svc.findAll();

        verify(repo, times(1)).findAll();
    }

    @Test
    void findByPlate() {
        when(repo.findByPlate(any(Plate.class))).thenReturn(Optional.of(car));

        svc.findByPlate("AA-11-AA");

        verify(repo, times(1)).findByPlate(any(Plate.class));
    }
}