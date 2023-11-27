package com.example.HealthWave.service;

import com.example.HealthWave.data.PatientRegister;
import com.example.HealthWave.repository.ResetPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ResetPasswordService {
    @Autowired
    private ResetPasswordRepository resetPasswordRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    private final Map<String, String> otpMap = new HashMap<>();

    public boolean resetPassword(String email) {
        String otp = generateRandomOTP();
        long expirationTime = System.currentTimeMillis() + 60000;

        otpMap.put(email, otp + ":" + expirationTime);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset OTP");
        message.setText("Your OTP for password reset is: " + otp);

        try {
            javaMailSender.send(message);
            System.out.println("Reset Password OTP sent to " + email);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to send reset OTP. Error: " + e.getMessage());
            return false;
        }
    }

    @Scheduled(fixedDelay = 60000)
    public void clearExpiredTokens() {
        long currentTime = System.currentTimeMillis();

        otpMap.entrySet().removeIf(entry -> (currentTime - Long.parseLong(entry.getValue())) > 60000);
    }

    public boolean verifyOTP(String email, String submittedOTP) {
        String storedValue = otpMap.get(email);

        if (storedValue != null) {
            String[] parts = storedValue.split(":");
            String storedOTP = parts[0];
            long timestamp = Long.parseLong(parts[1]);

            if ((System.currentTimeMillis() - timestamp) <= 60000 && storedOTP.equals(submittedOTP)) {
                return true;
            } else {
                otpMap.remove(email);
            }
        }

        return false;
    }

    private String generateRandomOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public boolean updatePassword(String email, String newPassword) {
        PatientRegister patientRegister = resetPasswordRepository.findByEmail(email);

        if (patientRegister != null) {
            patientRegister.setPassword(newPassword);
            resetPasswordRepository.save(patientRegister);
            return true;
        } else {
            return false;
        }
    }
}
