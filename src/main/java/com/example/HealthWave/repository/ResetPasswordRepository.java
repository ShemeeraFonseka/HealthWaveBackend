package com.example.HealthWave.repository;

import com.example.HealthWave.data.PatientRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetPasswordRepository extends JpaRepository<PatientRegister, Integer> {
    PatientRegister findByUsername(String username);
    PatientRegister findByEmail(String email);
}
