package com.example.HealthWave.controller;


import com.example.HealthWave.model.DoctorRegister;
import com.example.HealthWave.service.DoctorRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorRegisterController {
    @Autowired
    DoctorRegisterService doctorRegisterService;
    @PostMapping("/register")
    public DoctorRegister registerDoctor(@RequestBody DoctorRegister doctor){
        return doctorRegisterService.registerDoctor(doctor);
    }

    @GetMapping("/all")
    public List<DoctorRegister> getAllDoctors() {
        return doctorRegisterService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorRegister getDoctorById(@PathVariable int id) {
        return doctorRegisterService.getDoctorById(id);
    }

    @PutMapping("/{id}")
    public DoctorRegister updateDoctorInfo(@PathVariable int id, @RequestBody DoctorRegister updatedDoctor) {
        return doctorRegisterService.updateDoctorInfo(id, updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable int id) {
        doctorRegisterService.deleteDoctorById(id);
    }




}
