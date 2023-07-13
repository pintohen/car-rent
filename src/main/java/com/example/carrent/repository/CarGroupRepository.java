package com.example.carrent.repository;

import com.example.carrent.domain.car.group.CarClass;
import com.example.carrent.domain.car.group.CarGroup;
import com.example.carrent.domain.car.group.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarGroupRepository extends JpaRepository<CarGroup, Long> {
    List<CarGroup> findByCarClass(CarClass carClass);
    Optional<CarGroup> findByName(Name name);
}
