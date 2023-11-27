package com.example.HealthWave.controller;

import com.example.HealthWave.data.Appointment;
import com.example.HealthWave.data.PatientRegister;
import com.example.HealthWave.service.PatientRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PatientRegisterController {

    @Autowired
    private PatientRegisterService patientRegisterService;

    @GetMapping(path="/registeredpatients")
    public List<PatientRegister> getAllRegisteredPatients()
    {
        return patientRegisterService.getAllRegisteredPatients();
    }

    @PostMapping(path = "/registerpatient")
    public  PatientRegister createPatientRegister(@RequestBody PatientRegister patientRegister)
    {
        return patientRegisterService.createPatientRegister(patientRegister);
    }

    @GetMapping(path="/registeredpatients",params="patientName")
    public List<PatientRegister> getDetailsByPatient(@RequestParam String patientName)
    {
        return patientRegisterService.getDetailsByPatient(patientName);
    }

    @GetMapping("/patientcount")
    public ResponseEntity<Integer> countPatients() {
        int count = patientRegisterService.countPatients();
        return ResponseEntity.ok(count);
    }

    @GetMapping(path = "/viewPatientDetails", params = "patientId")
    public PatientRegister getPatientDetails(@RequestParam int patientId) {
        return patientRegisterService.getPatientDetails(patientId);
    }
}
