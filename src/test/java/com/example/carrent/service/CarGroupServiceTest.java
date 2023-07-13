package com.example.carrent.service;

import com.example.carrent.domain.car.Car;
import com.example.carrent.domain.car.group.CarClass;
import com.example.carrent.domain.car.group.CarGroup;
import com.example.carrent.domain.car.group.CarGroupFactory;
import com.example.carrent.domain.car.group.Name;
import com.example.carrent.repository.CarGroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CarGroupServiceTest {

    @Mock
    CarGroupRepository repo;
    CarGroupService svc;

    CarGroup mock;

    @BeforeEach
    void setUp() {
        repo = mock();
        svc = new CarGroupService(repo);

        mock = CarGroupFactory.createCarGroup(
                "name",
                "4",
                "17.5",
                "LUXURY"
        );
    }

    @Test
    void createCarGroup() {
        when(repo.save(any(CarGroup.class))).thenReturn(mock);

        svc.createCarGroup("name", "4", "17.5", "LUXURY");

        verify(repo, times(1)).save(any(CarGroup.class));
    }

    @Test
    void findAll() {
        when(repo.findAll()).thenReturn(List.of(mock));

        svc.findAll();

        verify(repo, times(1)).findAll();
    }

    @Test
    void findById() {
        when(repo.findById(any(Long.class))).thenReturn(Optional.of(mock));

        Long id = 1L;

        svc.findById(id);

        verify(repo, times(1)).findById(id);
    }

    @Test
    void findByName() {
        when(repo.findByName(any(Name.class))).thenReturn(Optional.of(mock));

        String name = "name";

        svc.findByName(name);

        verify(repo, times(1)).findByName(any(Name.class));
    }

    @Test
    void findByCarClass() {
        when(repo.findByCarClass(any(CarClass.class))).thenReturn(List.of(mock));

        String carClass = "LUXURY";

        svc.findByCarClass(carClass);

        verify(repo, times(1)).findByCarClass(any(CarClass.class));
    }
}