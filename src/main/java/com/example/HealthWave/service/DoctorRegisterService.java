package com.example.HealthWave.service;

import com.example.HealthWave.model.DoctorRegister;
import com.example.HealthWave.repository.DoctorRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorRegisterService {
    @Autowired
    private DoctorRegisterRepository doctorRegisterRepository;
    public DoctorRegister registerDoctor(DoctorRegister doctor) {
        return doctorRegisterRepository.save(doctor);
    }
    public List <DoctorRegister> getAllDoctors() {
        return doctorRegisterRepository.findAll();
    }

    public DoctorRegister getDoctorById(int id) {
        Optional<DoctorRegister> optionalDoctor = doctorRegisterRepository.findById(id);
        return optionalDoctor.orElse(null);
    }

    public DoctorRegister updateDoctorInfo(int id, DoctorRegister updatedDoctor) {
        Optional<DoctorRegister> optionalDoctor = doctorRegisterRepository.findById(id);

        if (optionalDoctor.isPresent()) {
            DoctorRegister existingDoctor = optionalDoctor.get();

            existingDoctor.setDoctorName(updatedDoctor.getDoctorName());
            existingDoctor.setPhone(updatedDoctor.getPhone());
            existingDoctor.setEmail(updatedDoctor.getEmail());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            existingDoctor.setHospitalName(updatedDoctor.getHospitalName());
            existingDoctor.setExperience(updatedDoctor.getExperience());
            existingDoctor.setDoctorFee(updatedDoctor.getDoctorFee());
            existingDoctor.setDoctorAvailabilityDate(updatedDoctor.getDoctorAvailabilityDate());
            existingDoctor.setDoctorAvailabilityTime(updatedDoctor.getDoctorAvailabilityTime());

            return doctorRegisterRepository.save(existingDoctor);
        } else {
            return null;
        }
    }
    public void deleteDoctorById(int id) {
        doctorRegisterRepository.deleteById(id);
    }




}
