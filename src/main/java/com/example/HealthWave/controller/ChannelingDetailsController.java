package com.example.HealthWave.controller;

import com.example.HealthWave.model.ChannelingDetailsModel;
import com.example.HealthWave.service.ChannelingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChannelingDetailsController {

    @Autowired
    ChannelingDetailsService channelingDetailsService;


    @GetMapping("/get_channelingDetails")
    public List<ChannelingDetailsModel> getChannelingDetails(@RequestParam int patientId)
    {
        return channelingDetailsService.getChannelingDetails(patientId);
    }
}
