package com.example.HealthWave.service;

import com.example.HealthWave.model.ConversationModel;
import com.example.HealthWave.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConversationService {

    @Autowired
    ConversationRepository conversationRepository;

    public void sendMessage(ConversationModel conversationModel)
    {
        conversationModel.setUpdatedTime(new Date());
        conversationRepository.save(conversationModel);
    }

    public List<ConversationModel> getMessages(int doctorId, int patientId)
    {
        return conversationRepository.getMessages( doctorId, patientId );
    }


}
