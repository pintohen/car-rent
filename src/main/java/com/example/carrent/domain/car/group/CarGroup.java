package com.example.carrent.domain.car.group;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CarGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Name name;
    private NumberOfDoors numberOfDoors;
    private DailyPrice dailyPrice;
    @Enumerated(EnumType.STRING)
    @Column(name = "car_class", nullable = false)
    private CarClass carClass;


    public CarGroup() {
    }

    public CarGroup(Name name, NumberOfDoors numberOfDoors, DailyPrice dailyPrice, CarClass carClass) {
        this.name = name;
        this.numberOfDoors = numberOfDoors;
        this.dailyPrice = dailyPrice;
        this.carClass = carClass;
    }
}
