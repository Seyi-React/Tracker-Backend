package com.oluwaseyi.tracker.service.impl;

import com.oluwaseyi.tracker.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public void sendActivationEmail(String to, String activationCode) {
        // Here you would integrate with a real email service
        logger.info("Sending activation email to {} with code: {}", to, activationCode);
        // Example: mailSender.send(...)
    }
}
