package com.example.HealthWave.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRegisterRepository extends JpaRepository<PatientRegister,Integer> {
    @Query("SELECT a FROM PatientRegister a WHERE a.patient_name LIKE %:patientName%")
    List<PatientRegister> findByPatientNameContainingIgnoreCase(@Param("patientName") String patientName);

    PatientRegister findByUsername(String username);

    @Query(value = "SELECT * FROM patient_register a WHERE a.patient_id = ?1", nativeQuery = true)
    PatientRegister findPatientById(int patientId);

}
