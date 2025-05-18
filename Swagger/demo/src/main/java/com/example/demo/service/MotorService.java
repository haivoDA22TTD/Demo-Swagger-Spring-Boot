package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Motor;
import com.example.demo.repository.MotorRepository;

@Service
public class MotorService {
      @Autowired
    private MotorRepository motorRepository;

    public List<Motor> getAllMotors() {
        return motorRepository.findAll();
    }

    public Optional<Motor> getMotorById(Long id) {
        return motorRepository.findById(id);
    }

    public Motor saveMotor(Motor motor) {
        return motorRepository.save(motor);
    }
    
    public void deleteMotor(Long id) {
        motorRepository.deleteById(id);
    }
}
