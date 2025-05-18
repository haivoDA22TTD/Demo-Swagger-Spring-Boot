package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Motor;
import com.example.demo.service.MotorService;

import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/api/motors")
public class MotorController {
      @Autowired
    private MotorService motorService;

    @Operation(summary = "Get all motors")
    @GetMapping
    public List<Motor> getAllMotors() {
        return motorService.getAllMotors();
    }

    @Operation(summary = "Get motor by ID")
    @GetMapping("/{id}")
    public Optional<Motor> getMotorById(@PathVariable Long id) {
        return motorService.getMotorById(id);
    }

    @Operation(summary = "Create new motor")
    @PostMapping
public ResponseEntity<Motor> createMotor(@RequestBody Motor motor) {
    motor.setId(null); // đảm bảo thêm mới
    Motor saved = motorService.saveMotor(motor);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
}


    @Operation(summary = "Delete motor by ID")
    @DeleteMapping("/{id}")
    public void deleteMotor(@PathVariable Long id) {
        motorService.deleteMotor(id);
    }
}

