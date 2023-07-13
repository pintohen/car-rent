package com.example.carrent.controller;

import com.example.carrent.dto.CarGroupDTO;
import com.example.carrent.service.CarGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/car-group")
public class CarGroupController {

    private final CarGroupService svc;

    @Autowired
    public CarGroupController(CarGroupService svc) {
        this.svc = svc;
    }

    record CarGroupRequest(String name, String numberOfDoors, String dailyPrice, String carClass) {
    }

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<?> registerCarGroup(@RequestBody CarGroupRequest request) {
        try{
            CarGroupDTO group = svc.createCarGroup(
                    request.name(),
                    request.numberOfDoors(),
                    request.dailyPrice(),
                    request.carClass()
            );

            return ResponseEntity.ok(group);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCarGroups() {
        return ResponseEntity.ok(svc.findAll());
    }

    @GetMapping(value = "/all/name={name}")
    public ResponseEntity<?> getAllCarGroupsOfName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(svc.findByName(name));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/all/class={carClass}")
    public ResponseEntity<?> getAllCarGroupsOfClass(@PathVariable String carClass) {
        try {
            return ResponseEntity.ok(svc.findByCarClass(carClass));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
