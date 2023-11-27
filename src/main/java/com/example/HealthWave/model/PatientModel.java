package com.example.HealthWave.model;

import jakarta.persistence.*;

@Entity
@Table (name="patient_register")
public class PatientModel {

    @Column(name = "patient_name")
    private String patientName;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="patient_id")
    private  Long id;

    private String email;

    @Column(name = "phone_number")
    private int phoneNumber;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
