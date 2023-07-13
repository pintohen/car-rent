package com.example.carrent.controller;

import com.example.carrent.domain.TestEntity;
import com.example.carrent.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class TestController {

    private final TestRepository testRepo;

    @Autowired
    public TestController(TestRepository testRepo) {
        this.testRepo = testRepo;
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<TestEntity> test(@PathVariable Long id){
        TestEntity found = testRepo.findById(id)
                .orElse(null);

        if(found == null)
            return ResponseEntity.status(404)
                    .build();

        return ResponseEntity.ok(found);
    }

    @GetMapping("/tests")
    public ResponseEntity<List<TestEntity>> tests(){
       return ResponseEntity.ok(testRepo.findAll());
    }

    record TestEntityBody(String name){

    }

    @PostMapping(value = "/test", consumes = "application/json")
    public ResponseEntity<TestEntity> createTest(@RequestBody TestEntityBody test){
        return ResponseEntity.ok(testRepo.save(new TestEntity(test.name())));
    }
}
