package com.example.HealthWave.controller;

import com.example.HealthWave.data.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AdminLoginController {

    private AdminLoginRepository adminLoginRepository;

    public AdminLoginController(AdminLoginRepository adminLoginRepository) {
        this.adminLoginRepository = adminLoginRepository;
    }

    @PostMapping("/adminlogin")
    public ResponseEntity<?> login(@RequestBody AdminLoginRequest adminLoginRequest) {
        String username = adminLoginRequest.getUsername();
        String password = adminLoginRequest.getPassword();

        Optional<AdminLogin> optionalAdminLogin = adminLoginRepository.findByUsernameAndPassword(username, password);

        if (optionalAdminLogin.isPresent()) {
            AdminLogin adminLogin = optionalAdminLogin.get();
            return ResponseEntity.ok(adminLogin);
        } else {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
