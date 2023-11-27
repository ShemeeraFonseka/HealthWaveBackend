package com.example.HealthWave.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminLoginRepository extends JpaRepository<AdminLogin,Integer> {

    Optional<AdminLogin> findByUsernameAndPassword(String username, String password);
}
