package com.example.HealthWave.service;
import com.example.HealthWave.data.Appointment;
import com.example.HealthWave.data.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments;
    }

    public Appointment createAppointment(Appointment app) {
        String doctorName = app.getDoctor_name();  // Get the doctor's name from the new appointment
        int currentPatientNo = getCurrentPatientNoForDoctor(doctorName);

        int newPatientNo = currentPatientNo + 1;
        app.setPatient_no(newPatientNo);

        return appointmentRepository.save(app);
    }
    private int getCurrentPatientNoForDoctor(String doctorName) {
        Integer maxPatientNo = appointmentRepository.findMaxPatientNoForDoctorByName(doctorName);
        return maxPatientNo != null ? maxPatientNo : 0;
    }

    private int getCurrentPatientNoForDoctorFromDatabase(String doctorName) {
        return appointmentRepository.findMaxPatientNoForDoctorByName(doctorName);
    }

    public List<Appointment>getAppointmentsByPatient(String patientName){
        return appointmentRepository.findByPatientNameContainingIgnoreCase(patientName);
    }

    public int countAppointmentsForDay(LocalDate date) {
        return appointmentRepository.countAppointmentsForDay(date);
    }
}
