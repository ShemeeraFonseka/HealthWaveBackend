package com.example.HealthWave.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    @Query("SELECT MAX(a.patient_no) FROM Appointment a WHERE a.doctor_name = :doctorName")
    Integer findMaxPatientNoForDoctorByName(@Param("doctorName") String doctorName);

    @Query("SELECT a FROM Appointment a WHERE a.patient_name LIKE %:patientName%")
    List<Appointment> findByPatientNameContainingIgnoreCase(@Param("patientName") String patientName);

    @Query("SELECT COUNT(a) FROM Appointment a WHERE DATE(a.appointment_date) = :date")
    int countAppointmentsForDay(@Param("date") LocalDate date);
}
