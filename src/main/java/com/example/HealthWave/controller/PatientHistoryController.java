package com.example.HealthWave.controller;

import com.example.HealthWave.model.PatientHistoryModel;
import com.example.HealthWave.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientHistoryController {

    @Autowired
    PatientHistoryService patientHistoryService;

    @GetMapping("/getPatientDetails")
    public PatientHistoryModel getPatientDetails(@RequestParam int patient_id) {
        return patientHistoryService.getPatientDetails(patient_id);
    }

    @GetMapping("/getPatientMedications")
    public List<PatientHistoryModel> getPatientMedications(@RequestParam int patient_id) {
        return patientHistoryService.getPatientMedications(patient_id);
    }

    @PostMapping("/savePatientMedications")
    public PatientHistoryModel savePatientDetails(@RequestBody PatientHistoryModel patientHistoryModel)
    {
        return patientHistoryService.savePatientDetails(patientHistoryModel);
    }
}
