package com.example.HealthWave.data;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;


@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointment_id;

    @Column(name="patient_name")
    private String patient_name;

    @Column(name="patient_id")
    private int patient_id;

    @Column(name="phone_number")
    private int phone_number;

    @Column(name="email")
    private String email;

    @Column(name="doctor_name")
    private String doctor_name;

    @Column(name="patient_no")
    private int patient_no;

    @Column(name="doctor_date")
    private String doctor_date;

    @Column(name="doctor_time")
    private String doctor_time;

    @Column(name="appointment_date")
    private String appointment_date;

    @Column(name="appointment_time")
    private String appointment_time;

    @Column(name="doctor_fee")
    private int doctor_fee;

    @Column(name="hospital_fee")
    private int hospital_fee;

    @Column(name="total_fee")
    private int total_fee;

    public Appointment() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());

        this.appointment_date = dateFormat.format(currentDate);
        this.appointment_time = timeFormat.format(currentDate);
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public int getPatient_no() {
        return patient_no;
    }

    public void setPatient_no(int patient_no) {
        this.patient_no = patient_no;
    }

    public String getDoctor_date() {
        return doctor_date;
    }

    public void setDoctor_date(String doctor_date) {
        this.doctor_date = doctor_date;
    }

    public String getDoctor_time() {
        return doctor_time;
    }

    public void setDoctor_time(String doctor_time) {
        this.doctor_time = doctor_time;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public int getDoctor_fee() {
        return doctor_fee;
    }

    public void setDoctor_fee(int doctor_fee) {
        this.doctor_fee = doctor_fee;
    }

    public int getHospital_fee() {
        return hospital_fee;
    }

    public void setHospital_fee(int hospital_fee) {
        this.hospital_fee = hospital_fee;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }
}
