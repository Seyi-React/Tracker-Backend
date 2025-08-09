package com.oluwaseyi.tracker.service;

public interface EmailService {
    void sendActivationEmail(String to, String activationCode);
}
