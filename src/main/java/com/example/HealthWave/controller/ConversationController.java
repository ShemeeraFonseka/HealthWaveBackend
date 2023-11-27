package com.example.HealthWave.controller;

import com.example.HealthWave.model.ConversationModel;
import com.example.HealthWave.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConversationController {

    @Autowired
    ConversationService conversationService;

    @PostMapping("/send_message")
    public void sendMessage(@RequestBody ConversationModel conversationModel)
    {
        conversationService.sendMessage(conversationModel);
    }

    @GetMapping("/get_messages")
    public List<ConversationModel> getMessages(@RequestParam int doctorId, @RequestParam int patientId)
    {
        return conversationService.getMessages( doctorId, patientId );
    }


}
