package com.developer.colorblast.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /*public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("colorblastpa@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }*/

    public void sendEmail(String to, String subject, String newPassword) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            // Définir le destinataire, le sujet et le contenu de l'e-mail
            helper.setTo(to);
            helper.setSubject(subject);

            // Utilisez HTML pour mettre en forme le contenu de l'e-mail
            String htmlContent = "<html>"
                    + "<body>"
                    + "<h1 style='color: #007bff;'>Demande de changement de mot de passe</h1>"
                    + "<p>Vous avez fait une demande de changement de mot de passe.</p>"
                    + "<p>Voici votre nouveau mot de passe : <strong>" + newPassword + "</strong></p>"
                    + "<p>Après vous être connecté, vous pouvez aller dans votre profil pour changer de mot de passe.</p>"
                    + "</body>"
                    + "</html>";

            helper.setText(htmlContent, true); // Le deuxième argument (true) indique que le contenu est au format HTML

            mailSender.send(message);
        } catch (Exception e) {
            // Gérer les erreurs d'envoi de l'e-mail
            e.printStackTrace();
        }
    }

    public void sendHelpEmail(String from, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo("colorblastpa@gmail.com");
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public void sendEmailWithLinkAndButton(String to, String link) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject("Avis produit");

        String content = "<html>"
                + "<body>"
                + "<h1 style='color: #007bff;'>Avis produit</h1>"
                + "<p>Merci d'avoir effectué des achats sur notre application ColorBlast.</p>"
                + "<p>Si vous le souhaitez, vous pouvez donner votre avis sur chaque produit en cliquant sur le bouton ci-dessous :</p>"
                + "<p><a href=\"" + link + "\">"
                + "<button style='background-color: #007bff; color: white; padding: 10px 20px; border: none; cursor: pointer;'>Donner un avis</button>"
                + "</a></p>"
                + "</body>"
                + "</html>";

        helper.setText(content, true);

        mailSender.send(message);
    }

}
