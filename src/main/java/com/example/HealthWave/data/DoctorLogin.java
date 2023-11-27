package com.example.HealthWave.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="doctor_info")
@Entity
public class DoctorLogin {

    @Id
    @Column(name = "doctor_id")
    private int doctor_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String  password;

    @Column(name = "doctor_name")
    private String  doctor_name;

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
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

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }
}
