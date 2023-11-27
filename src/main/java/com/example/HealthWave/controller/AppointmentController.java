package com.example.HealthWave.controller;

import com.example.HealthWave.data.Appointment;
import com.example.HealthWave.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(path = "/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping(path = "/createAppointment")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping(path="/appointments",params="patientName")
    public List<Appointment> getAppointmentsByPatient(@RequestParam String patientName)
    {
        return appointmentService.getAppointmentsByPatient(patientName);
    }

    @GetMapping("/countForDay")
    public ResponseEntity<Integer> countAppointmentsForDay(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        int count = appointmentService.countAppointmentsForDay(date);
        return ResponseEntity.ok(count);
    }
}
