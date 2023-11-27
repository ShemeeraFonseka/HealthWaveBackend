package com.example.HealthWave.service;

import com.example.HealthWave.data.Appointment;
import com.example.HealthWave.data.PatientRegister;
import com.example.HealthWave.data.PatientRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientRegisterService {

    @Autowired
    private PatientRegisterRepository patientRegisterRepository;

    public List<PatientRegister>getAllRegisteredPatients()
    {
        List<PatientRegister> patientRegisters=patientRegisterRepository.findAll();
        return patientRegisters;
    }

    public PatientRegister createPatientRegister(PatientRegister pat)
    {
        return patientRegisterRepository.save(pat);
    }

    public List<PatientRegister>getDetailsByPatient(String patientName){
        return patientRegisterRepository.findByPatientNameContainingIgnoreCase(patientName);
    }

    public int countPatients() {
        return (int) patientRegisterRepository.count();
    }

    public PatientRegister getPatientDetails(int patientId){
        return patientRegisterRepository.findPatientById(patientId);
    }
}
