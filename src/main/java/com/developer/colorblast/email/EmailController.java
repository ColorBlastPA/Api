package com.developer.colorblast.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send-email")
    public String sendEmail() {
        String to = "kevin.mazure.km@gmail.com";
        String subject = "Test d'envoi d'e-mail";
        String body = "Ceci est un e-mail de test envoyé depuis Spring Boot.";

        emailService.sendEmail(to, subject, body);

        return "E-mail envoyé avec succès.";
    }
}
