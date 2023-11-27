package com.example.HealthWave.service;

import com.example.HealthWave.model.ChannelingDetailsModel;
import com.example.HealthWave.repository.ChannelingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChannelingDetailsService {

    @Autowired
    ChannelingDetailsRepository channelingDetailsRepository;

    public  List<ChannelingDetailsModel> getChannelingDetails(int patientId)
    {
        return channelingDetailsRepository.getChannelingDetails( patientId );
    }
}
