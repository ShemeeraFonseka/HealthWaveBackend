package com.example.HealthWave.repository;

import com.example.HealthWave.model.ChannelingDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelingDetailsRepository extends JpaRepository <ChannelingDetailsModel , Long > {

    @Query(value = "SELECT * FROM appointments WHERE patient_id=?1", nativeQuery = true)
    List<ChannelingDetailsModel> getChannelingDetails(int patientId);
}
