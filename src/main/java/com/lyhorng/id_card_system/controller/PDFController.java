package com.lyhorng.id_card_system.controller;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/pdf")
public class PDFController {

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdf(
            @RequestParam String name,
            @RequestParam String registrationNumber) {

        try {

            Document document = new Document();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, outputStream);

            document.open();

            document.add(new Paragraph("Student ID Card"));
            document.add(new Paragraph("-------------------------"));
            document.add(new Paragraph("Name: " + name));
            document.add(new Paragraph("Registration Number: "
                    + registrationNumber));

            document.close();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=id-card.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(outputStream.toByteArray());

        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();
        }
    }
}