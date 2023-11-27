package com.example.HealthWave.service;

import com.example.HealthWave.model.PatientHistoryModel;
import com.example.HealthWave.repository.PatientHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientHistoryService {

    @Autowired
    PatientHistoryRepository patientHistoryRepository;

    public PatientHistoryModel getPatientDetails (int patientId)
    {
        return  patientHistoryRepository.getPatientDetails(patientId);
    }

    public List<PatientHistoryModel> getPatientMedications (int patientId)
    {
        return  patientHistoryRepository.getPatientMedications(patientId);
    }

    public PatientHistoryModel savePatientDetails (PatientHistoryModel patientHistoryModel)
    {
        return  patientHistoryRepository.save(patientHistoryModel);
    }
}
