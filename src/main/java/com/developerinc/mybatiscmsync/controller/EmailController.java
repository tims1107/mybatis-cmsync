package com.developerinc.mybatiscmsync.controller;

import com.developerinc.mybatiscmsync.model.EmailRequest;
import com.developerinc.mybatiscmsync.service.EmailService;

import com.developerinc.mybatiscmsync.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private ExcelService excelService;



    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {

        System.out.println(emailRequest.getAttachmentPath());
        try {
            excelService.getExcelData();
           emailService.sendEmailWithAttachment(emailRequest.getTo(), emailRequest.getCc(),emailRequest.getSubject(), emailRequest.getBody(), emailRequest.getAttachmentPath());
            return ResponseEntity.ok("Email sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email: " + e.getMessage());
        }
    }
}