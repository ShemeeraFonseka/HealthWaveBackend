package com.example.HealthWave.controller;

import com.example.HealthWave.data.PatientRegister;
import com.example.HealthWave.service.PatientRegisterService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class PDFBoxController {

    @Autowired
    private PatientRegisterService patientRegisterService;

    @GetMapping("/registered-patients-report")
    public void generatePatientsReport(HttpServletResponse response) {
        try {
            // Fetch patient data
            List<PatientRegister> patients = patientRegisterService.getAllRegisteredPatients();

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
                contentStream.showText("Patient Name");
                contentStream.newLineAtOffset(150, 0);
                contentStream.showText("Registered Date");
                contentStream.newLineAtOffset(150, 0);  // Adjusted offset for the third column
                contentStream.showText("Registered Time");
                contentStream.setNonStrokingColor(Color.BLACK);
                contentStream.newLineAtOffset(-300, -20);  // Adjusted offset for the next row

                // Add patient data to the table
                for (PatientRegister patient : patients) {
                    contentStream.showText(patient.getPatient_name());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText(patient.getRegistered_date().toString());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText(patient.getRegistered_time().toString());
                    contentStream.newLineAtOffset(-300, -20);
                }

                contentStream.endText();
            }

            // Set the response headers for download
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename=registeredPatients_report.pdf");

            // Save the document to the response output stream
            document.save(response.getOutputStream());
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/patient-credentials-report")
    public void generatePatientCredentialsReport(HttpServletResponse response) {
        try {
            // Fetch patient data
            List<PatientRegister> patients = patientRegisterService.getAllRegisteredPatients();

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
                contentStream.showText("Patient Name");
                contentStream.newLineAtOffset(150, 0);
                contentStream.showText("Username");
                contentStream.newLineAtOffset(150, 0);  // Adjusted offset for the third column
                contentStream.showText("Password");
                contentStream.setNonStrokingColor(Color.BLACK);
                contentStream.newLineAtOffset(-300, -20);  // Adjusted offset for the next row

                // Add patient data to the table
                for (PatientRegister patient : patients) {
                    contentStream.showText(patient.getPatient_name());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText(patient.getUsername());
                    contentStream.newLineAtOffset(150, 0);
                    contentStream.showText(patient.getPassword());
                    contentStream.newLineAtOffset(-300, -20);
                }

                contentStream.endText();
            }

            // Set the response headers for download
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename=patient_credentials_report.pdf");

            // Save the document to the response output stream
            document.save(response.getOutputStream());
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
