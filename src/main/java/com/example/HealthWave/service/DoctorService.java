package com.example.HealthWave.service;

import com.example.HealthWave.model.DoctorModel;
import com.example.HealthWave.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;


    public List<DoctorModel> getChannelDoctors (int patientId)
    {
        return  doctorRepository.getChannelDoctors(patientId);
    }
}
