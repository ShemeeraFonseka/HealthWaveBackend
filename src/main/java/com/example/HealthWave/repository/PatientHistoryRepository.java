package com.example.HealthWave.repository;

import com.example.HealthWave.model.PatientHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientHistoryRepository extends JpaRepository<PatientHistoryModel,Long> {

    @Query(value = "SELECT pr.patient_id, pr.patient_name, pr.email, pr.phone_number, ph.blood_type, ph.date, ph.weight, ph.height, ph.age, ph.blood_pressure, ph.blood_sugar, ph.diagnosis, ph.medication" +
            " FROM patient_register pr LEFT JOIN patient_history ph ON pr.patient_id = ph.patient_id WHERE pr.patient_id = ?1",
            nativeQuery = true)
    PatientHistoryModel getPatientDetails(int patient_id);

    @Query(value = "SELECT ph.id, pr.patient_id, pr.patient_name, pr.email, pr.phone_number, ph.blood_type, ph.weight, ph.date, ph.height, ph.age, ph.blood_pressure, ph.blood_sugar, ph.diagnosis, ph.medication, ph.doctor_id, (SELECT doctor_name from doctor_info where doctor_id = ph.doctor_id ) as doctor_name" +
            " FROM patient_register pr LEFT JOIN patient_history ph ON pr.patient_id = ph.patient_id WHERE pr.patient_id = ?1",
            nativeQuery = true)
    List<PatientHistoryModel> getPatientMedications(int patient_id);

}
