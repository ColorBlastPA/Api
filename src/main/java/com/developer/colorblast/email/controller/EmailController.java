package com.developer.colorblast.email.controller;

import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.client.service.ClientService;
import com.developer.colorblast.email.service.EmailService;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;
import com.developer.colorblast.pro.service.ProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.security.SecureRandom;
import java.util.Optional;
@CrossOrigin
@RestController
public class EmailController {

    private final EmailService emailService;
    private final ClientService clientService;

    private final ProfessionnelService professionnelService;

    @Autowired
    public EmailController(EmailService emailService, ClientService clientService, ProfessionnelService professionnelService) {
        this.emailService = emailService;
        this.clientService = clientService;
        this.professionnelService = professionnelService;
    }

    @GetMapping("/send-email")
    public String sendEmail() {
        String to = "kevin.mazure.km@gmail.com";
        String link = "http://localhost:3000/commentProduct/a6f0d4f7-9c3e-4e79-8522-7c9fda3etest";

        try {
            emailService.sendEmailWithLink(to, link);
            return "E-mail envoyé avec succès.";
        } catch (MessagingException e) {
            return "Erreur lors de l'envoi de l'e-mail : " + e.getMessage();
        }
    }

    @GetMapping("/commentProduct/{email}/{key}")
    public String sendCommentProductEmail(@PathVariable String email, @PathVariable String key) {
        String to = email;
        String link = "http://localhost:3000/commentProduct/"+key;

        try {
            emailService.sendEmailWithLink(to, link);
            return "E-mail envoyé avec succès.";
        } catch (MessagingException e) {
            return "Erreur lors de l'envoi de l'e-mail : " + e.getMessage();
        }
    }



    @GetMapping("/forgotPasswordClient/{email}")
    public ResponseEntity<String> forgotPasswordClient(@PathVariable String email) {
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

    @GetMapping("/forgotPasswordPro/{email}")
    public ResponseEntity<String> forgotPasswordPro(@PathVariable String email) {
        Optional<ProfessionnelEntity> pro = professionnelService.findByMail(email);

        if (pro.isPresent()) {
            String newPassword = generateRandomPassword();

            pro.get().setPassword(newPassword);

            ProfessionnelEntity newPro = professionnelService.updateProfessionnel(pro.get());

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
