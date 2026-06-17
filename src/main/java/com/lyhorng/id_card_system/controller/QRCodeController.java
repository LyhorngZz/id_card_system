package com.lyhorng.id_card_system.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/qrcode")
public class QRCodeController {

    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(
            @RequestParam String text) {

        try {

            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            var bitMatrix = qrCodeWriter.encode(
                    text,
                    BarcodeFormat.QR_CODE,
                    300,
                    300);

            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();

            MatrixToImageWriter.writeToStream(
                    bitMatrix,
                    "PNG",
                    pngOutputStream);

            return ResponseEntity.ok(
                    pngOutputStream.toByteArray());

        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();
        }
    }
}