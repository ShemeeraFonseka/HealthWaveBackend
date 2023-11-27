package com.example.HealthWave.controller;

import com.example.HealthWave.model.DoctorModel;
import com.example.HealthWave.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/get_ChannelDoctors")
    public List<DoctorModel> getChannelDoctors(@RequestParam int patientId){
        return  doctorService.getChannelDoctors(patientId);
    }
}
