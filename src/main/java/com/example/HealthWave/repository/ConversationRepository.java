package com.example.HealthWave.repository;

import com.example.HealthWave.model.ConversationModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<ConversationModel, Long> {

    @Query(value = "SELECT * FROM conversation WHERE doctor_id = ?1 AND patient_id = ?2", nativeQuery = true)
    List<ConversationModel> getMessages(int doctorId, int patientId);


}
