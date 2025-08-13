package com.oluwaseyi.tracker.service.impl;

import com.oluwaseyi.tracker.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;

@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendActivationEmail(String to, String activationCode) {
        logger.info("Sending activation email to {} with code: {}", to, activationCode);
        String subject = "Activate Profile";
        String activationLink = "http://localhost:9090/api/activate?activationCode=" + activationCode;
        String content = "<h2>Activate your profile</h2>"
                + "<p>Click the link below to activate your profile:</p>"
                + "<a href='" + activationLink + "'>Activate Profile</a>";
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            logger.error("Failed to send activation email", e);
        }
    }
}
