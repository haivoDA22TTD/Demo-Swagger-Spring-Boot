package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Motor;

public interface MotorRepository extends JpaRepository<Motor, Long>{

}
