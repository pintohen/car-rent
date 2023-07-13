package com.example.carrent.controller;

import com.example.carrent.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestControllerTest {

    @Mock
    TestRepository testRepo;

    TestController ctrl;

    @BeforeEach
    void setUp() {
        testRepo = mock();
        ctrl = new TestController(testRepo);
    }

    @Test
    void test() {
        int i;

        for (i = 0; i < 1000; i++) {
            ctrl.test(1L);
        }

        verify(testRepo, times(i)).findById(1L);
    }

    @Test
    void tests() {
        int i;
        for (i = 0; i < 1000; i++) {
            ctrl.tests();
        }

        verify(testRepo, times(i)).findAll();
    }

    @Test
    void createTest() {
        int i;
        for (i = 0; i < 1000; i++) {
            ctrl.createTest(new TestController.TestEntityBody("test"));
        }

        verify(testRepo, times(i)).save(any());
    }
}