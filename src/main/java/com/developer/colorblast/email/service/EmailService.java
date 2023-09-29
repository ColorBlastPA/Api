package com.developer.colorblast.email.service;

import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;
import com.developer.colorblast.product.entity.ProductEntity;
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

    public void sendMessageForClientEmail(String from, String subject, ProfessionnelEntity pro, String to) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);

        // Utilisez HTML pour le contenu de l'e-mail avec un meilleur design
        String htmlContent = "<html><body style='font-family: Arial, sans-serif;'>";
        htmlContent += "<div style='background-color: #f2f2f2; padding: 20px;'>";
        htmlContent += "<div style='background-color: #ffffff; border: 1px solid #dddddd; border-radius: 5px; padding: 20px;'>";
        htmlContent += "<h1 style='color: #333333;'>Nouveau message de " + pro.getLastname() + " " + pro.getFirstname() + "</h1>";
        htmlContent += "<p style='color: #555555;'>Pour information, " + pro.getLastname() + " " + pro.getFirstname() + " vous a envoyé un message.</p>";
        htmlContent += "<p style='color: #555555;'>Si vous voulez voir son message, connectez-vous à l'application ColorBlast.</p>";
        htmlContent += "</div>";
        htmlContent += "</div>";
        htmlContent += "</body></html>";

        helper.setText(htmlContent, true);

        mailSender.send(message);
    }
    public void sendMessageForProEmail(String from, String subject, ClientEntity client, String to) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);

        // Utilisez HTML pour le contenu de l'e-mail avec un meilleur design
        String htmlContent = "<html><body>";
        htmlContent += "<div style='background-color: #f2f2f2; padding: 20px;'>";
        htmlContent += "<div style='background-color: #ffffff; border: 1px solid #dddddd; border-radius: 5px; padding: 20px;'>";
        htmlContent += "<h1 style='color: #333333;'>Nouveau message de " + client.getLastname() + " " + client.getFirstname() + "</h1>";
        htmlContent += "<p style='color: #555555;'>Pour information, " + client.getLastname() + " " + client.getFirstname() + " vous a envoyé un message.</p>";
        htmlContent += "<p style='color: #555555;'>Si vous voulez voir son message, connectez-vous à l'application ColorBlast.</p>";
        htmlContent += "</div>";
        htmlContent += "</div>";
        htmlContent += "</body></html>";

        helper.setText(htmlContent, true);

        mailSender.send(message);
    }

    public void sendEmailWithLinkAndButtonForProduct(String to, String link) throws MessagingException {
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

    public void sendEmailWithLinkAndButton(String to, String link) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject("Avis Service");

        String content = "<html>"
                + "<body>"
                + "<h1 style='color: #007bff;'>Avis Service</h1>"
                + "<p>Merci d'avoir utilisé ColorBlast pour votre service.</p>"
                + "<p>Si vous le souhaitez, vous pouvez donner votre avis sur le service effectué en cliquant sur le bouton ci-dessous :</p>"
                + "<p><a href=\"" + link + "\">"
                + "<button style='background-color: #007bff; color: white; padding: 10px 20px; border: none; cursor: pointer;'>Donner un avis</button>"
                + "</a></p>"
                + "</body>"
                + "</html>";

        helper.setText(content, true);

        mailSender.send(message);
    }

}
