package com.example.HealthWave.repository;

import com.example.HealthWave.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {

    @Query(value = "select DISTINCT patient_id,patient_name,email,phone_number from appointments where doctor_id=?1",
            nativeQuery = true)
    List<PatientModel> getPatientList(int doctorId);
}
