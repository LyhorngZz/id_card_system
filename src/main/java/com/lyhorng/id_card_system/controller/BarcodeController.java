package com.lyhorng.id_card_system.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/barcode")
public class BarcodeController {

    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateBarcode(
            @RequestParam String text,
            @RequestParam(defaultValue = "CODE_128") String type) {

        try {

            BarcodeFormat format = BarcodeFormat.CODE_128;

            if ("EAN_13".equalsIgnoreCase(type)) {
                format = BarcodeFormat.EAN_13;
            }

            var bitMatrix = new MultiFormatWriter().encode(
                    text,
                    format,
                    500,
                    200);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            MatrixToImageWriter.writeToStream(
                    bitMatrix,
                    "PNG",
                    outputStream);

            return ResponseEntity.ok(outputStream.toByteArray());

        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();
        }
    }
}