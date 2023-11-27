package com.example.HealthWave.controller;

import com.example.HealthWave.data.PatientRegister;
import com.example.HealthWave.model.DoctorRegister;
import com.example.HealthWave.service.DoctorRegisterService;
import com.example.HealthWave.service.PatientRegisterService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class DoctorPDFBoxController {

    @Autowired
    private DoctorRegisterService doctorRegisterService;

    @GetMapping("/registered-doctors-report")
    public void generateDoctorssReport(HttpServletResponse response) {
        try {
            // Fetch patient data
            List<DoctorRegister> doctors = doctorRegisterService.getAllDoctors();

            // Create a PDF document
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.setLineWidth(1.5f);


                // Calculate the center of the page
                float pageWidth = page.getMediaBox().getWidth();
                float tableWidth = 450;  // Adjusted for the total width of the table
                float startX = (pageWidth - tableWidth) / 2;

                contentStream.beginText();
                contentStream.newLineAtOffset(startX, 700);

                contentStream.setNonStrokingColor(Color.BLUE);
                // Add table headers
                contentStream.showText("Doctor Name");
                contentStream.newLineAtOffset(150, 0);
                contentStream.showText("Specialization");
                contentStream.newLineAtOffset(150, 0);  // Adjusted offset for the third column
                contentStream.showText("Hospital");
                contentStream.setNonStrokingColor(Color.BLACK);
                contentStream.newLineAtOffset(-300, -20);  // Adjusted offset for the next row

                // Add patient data to the table
                for (DoctorRegister doctor : doctors) {
                    contentStream.showText(doctor.getDoctorName());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText(doctor.getSpecialization());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText(doctor.getHospitalName());
                    contentStream.newLineAtOffset(-300, -20);
                }

                contentStream.endText();
            }

            // Set the response headers for download
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename=registeredDoctors_report.pdf");

            // Save the document to the response output stream
            document.save(response.getOutputStream());
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/doctor-credentials-report")
    public void generateDoctorCredentialsReport(HttpServletResponse response) {
        try {
            // Fetch patient data
            List<DoctorRegister> doctors = doctorRegisterService.getAllDoctors();

            // Create a PDF document
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.setLineWidth(1.5f);


                // Calculate the center of the page
                float pageWidth = page.getMediaBox().getWidth();
                float tableWidth = 450;  // Adjusted for the total width of the table
                float startX = (pageWidth - tableWidth) / 2;

                contentStream.beginText();
                contentStream.newLineAtOffset(startX, 700);

                contentStream.setNonStrokingColor(Color.BLUE);
                // Add table headers
                contentStream.showText("Doctor Name");
                contentStream.newLineAtOffset(150, 0);
                contentStream.showText("Username");
                contentStream.newLineAtOffset(150, 0);  // Adjusted offset for the third column
                contentStream.showText("Password");
                contentStream.setNonStrokingColor(Color.BLACK);
                contentStream.newLineAtOffset(-300, -20);  // Adjusted offset for the next row

                // Add patient data to the table
                for (DoctorRegister doctor : doctors) {
                    contentStream.showText(doctor.getDoctorName());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText(doctor.getUsername());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText(doctor.getPassword());
                    contentStream.newLineAtOffset(-300, -20);
                }

                contentStream.endText();
            }

            // Set the response headers for download
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename=doctor_credentials_report.pdf");

            // Save the document to the response output stream
            document.save(response.getOutputStream());
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
