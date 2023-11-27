package com.example.HealthWave.repository;

import com.example.HealthWave.model.DoctorRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface DoctorRegisterRepository extends JpaRepository<DoctorRegister , Integer > {




}
