package com.example.HealthWave.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorLoginRepository extends JpaRepository<DoctorLogin,Integer> {

    Optional<DoctorLogin> findByUsernameAndPassword(String username, String password);
}
