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
public class DoctorLoginController {

    private DoctorLoginRepository doctorLoginRepository;

    public DoctorLoginController(DoctorLoginRepository doctorLoginRepository) {
        this.doctorLoginRepository = doctorLoginRepository;
    }

    @PostMapping("/doctorlogin")
    public ResponseEntity<?> login(@RequestBody DoctorLoginRequest doctorLoginRequest) {
        String username = doctorLoginRequest.getUsername();
        String password = doctorLoginRequest.getPassword();

        Optional<DoctorLogin> optionalDoctorLogin = doctorLoginRepository.findByUsernameAndPassword(username, password);

        if (optionalDoctorLogin.isPresent()) {
            DoctorLogin doctorLogin = optionalDoctorLogin.get();
            return ResponseEntity.ok(doctorLogin);
        } else {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
