package com.example.HealthWave.service;

import com.example.HealthWave.model.PatientModel;
import com.example.HealthWave.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<PatientModel> getPatientList (int patientId)
    {
        return  patientRepository.getPatientList(patientId);
    }

//    public List<PatientModel> getPatientDetails (int patientId)
//    {
//        return  patientRepository.getPatientDetails(patientId);
//    }

//    public void updatePatientDetails(PatientModel patientModel)
//    {
//        patientRepository.updatePatientDetails(patientModel.getAge(), patientModel.getBloodType(), patientModel.getWeight(), patientModel.getHeight(),
//                patientModel.getBloodSugar(), patientModel.getBloodPressure(), patientModel.getDiagnosis(), patientModel.getMedication(),patientModel.getPatient_id());
//    }
}
