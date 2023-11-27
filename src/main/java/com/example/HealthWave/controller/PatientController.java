package com.example.HealthWave.controller;

import com.example.HealthWave.model.PatientModel;
import com.example.HealthWave.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @CrossOrigin(origins = "*")
    @GetMapping("/get_PatientList")
    public List<PatientModel> getPatientList(@RequestParam int doctorId) {
        return patientService.getPatientList(doctorId);
    }

//    @GetMapping("/get_PatientDetails")
//    public List<PatientModel> getPatientDetails(@RequestParam int patient_id) {
//        return patientService.getPatientDetails(patient_id);
//    }

//    @PostMapping(path = "/createPatientDetails")
//    public  void updatePatientDetails(@RequestBody PatientModel patientModel)
//    {
//        patientService.updatePatientDetails(patientModel);
//    }
}
