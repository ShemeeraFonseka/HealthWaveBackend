package com.example.HealthWave.controller;

import com.example.HealthWave.service.ResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class ResetPasswordController {

    @Autowired
    ResetPasswordService resetPasswordService;

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email) {
        boolean resetSuccess = resetPasswordService.resetPassword(email);

        if (resetSuccess) {
            return new ResponseEntity<>("Password reset OTP sent successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to send reset OTP. Invalid email or other issues.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/submit-otp")
    public ResponseEntity<String> submitOTP(@RequestParam String email, @RequestParam String otp) {
        boolean isOTPValid = resetPasswordService.verifyOTP(email, otp);

        if (isOTPValid) {
            return new ResponseEntity<>("OTP verification successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid OTP", HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestParam String email, @RequestParam String newPassword) {
        if (resetPasswordService.updatePassword(email, newPassword)) {
            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Patient not found with the given email");
        }
    }
}
