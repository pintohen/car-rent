package com.example.carrent.controller;

import com.example.carrent.domain.car.Car;
import com.example.carrent.dto.CarDTO;
import com.example.carrent.service.CarService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/car")
public class CarController {
    private final CarService svc;


    @Autowired
    public CarController(CarService svc) {
        this.svc = svc;
    }

    record CarRequest(String plate, String yearOfPurchase, String color, String cylinderValue, Long carGroupId) {
    }

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<?> registerCar(@RequestBody CarRequest requestBody) {
        try{
            CarDTO car = svc.createCar(
                    requestBody.plate(),
                    requestBody.yearOfPurchase(),
                    requestBody.color(),
                    requestBody.cylinderValue(),
                    requestBody.carGroupId()
            );
            return ResponseEntity.ok().body(car);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCars(){
        return ResponseEntity.ok(svc.findAll());
    }

    @GetMapping("/plate={plate}")
    public ResponseEntity<?> getCarByPlate(@PathVariable String plate){
        try{
            return ResponseEntity.ok(svc.findByPlate(plate));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/group={car_group_id}")
    public ResponseEntity<?> getCarsByCarGroup(@PathVariable Long car_group_id){
        try{
            return ResponseEntity.ok(svc.findCarsByCarGroup(car_group_id));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
