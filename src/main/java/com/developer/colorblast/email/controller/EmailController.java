package com.developer.colorblast.email.controller;

import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.client.service.ClientService;
import com.developer.colorblast.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.Optional;

@RestController
public class EmailController {

    private final EmailService emailService;
    private final ClientService clientService;

    @Autowired
    public EmailController(EmailService emailService, ClientService clientService) {
        this.emailService = emailService;
        this.clientService = clientService;
    }

    @GetMapping("/send-email")
    public String sendEmail() {
        String to = "kevin.mazure.km@gmail.com";
        String subject = "Test d'envoi d'e-mail";
        String body = "Ceci est un e-mail de test envoyé depuis Spring Boot.";

        emailService.sendEmail(to, subject, body);

        return "E-mail envoyé avec succès.";
    }


    @GetMapping("/forgotPassword/{email}")
    public ResponseEntity<String> forgotPassword(@PathVariable String email) {
        Optional<ClientEntity> client = clientService.findByMail(email);

        if (client.isPresent()) {
            String newPassword = generateRandomPassword();

            client.get().setPassword(newPassword);

            ClientEntity newClient = clientService.updateClient(client.get());

            String to = email;
            String subject = "Test d'envoi d'e-mail";
            String body = "Votre nouveau mot de passe est : " + newPassword;

            emailService.sendEmail(to, subject, body);

            return ResponseEntity.ok("E-mail envoyé avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String generateRandomPassword() {
        final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        int passwordLength = random.nextInt(3) + 8; // Random length between 8 and 10

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
