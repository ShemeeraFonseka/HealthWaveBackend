package com.example.HealthWave.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

@Entity
@Table(name = "doctor_info")
public class DoctorRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "phone")
    private int phone;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "hospital")
    private String hospitalName;

    @Column(name = "experience")
    private String experience;

    @Column (name = "doctor_fee")
    private double doctorFee;

    @Column (name = "doctor_availability_date")
    private String doctorAvailabilityDate;

    @Column (name = "doctor_availability_time")
    private String doctorAvailabilityTime;


    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public double getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(double doctorFee) {
        this.doctorFee = doctorFee;
    }

    public String getDoctorAvailabilityDate() {
        return doctorAvailabilityDate;
    }

    public void setDoctorAvailabilityDate(String doctorAvailabilityDate) {
        this.doctorAvailabilityDate = doctorAvailabilityDate;
    }

    public String getDoctorAvailabilityTime() {
        return doctorAvailabilityTime;
    }

    public void setDoctorAvailabilityTime(String doctorAvailabilityTime) {
        this.doctorAvailabilityTime = doctorAvailabilityTime;
    }
}
