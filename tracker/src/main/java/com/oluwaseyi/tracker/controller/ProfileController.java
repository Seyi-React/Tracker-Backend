package com.oluwaseyi.tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.oluwaseyi.tracker.entity.DTO.ProfileDTO;
import com.oluwaseyi.tracker.service.ProfileService;
import com.oluwaseyi.tracker.entity.DTO.LoginRequestDTO;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProfileController {
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    private final ProfileService profileService;
 

    @PostMapping("/login")
    public ResponseEntity<ProfileDTO> loginUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
        logger.info("Login attempt for email: {}", loginRequest.getEmail());
        try {
            return profileService.login(loginRequest);
        } catch (IllegalArgumentException e) {
            logger.error("Login failed for email: {}", loginRequest.getEmail(), e);
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ProfileDTO> createProfile(@RequestBody ProfileDTO profileDTO) {
        logger.info("Received request to register profile: {}", profileDTO);
        try {
            ProfileDTO created = profileService.createProfile(profileDTO);
            logger.info("Profile created: {}", created);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            logger.error("Error creating profile", e);
            throw e;
        }
    }

    @GetMapping("/profiles/{id}")
    public ResponseEntity<ProfileDTO> getProfileById(@PathVariable Long id) {
        logger.info("Fetching profile with id: {}", id);
        try {
            ProfileDTO profile = profileService.getProfileById(id);
            return ResponseEntity.ok(profile);
        } catch (Exception e) {
            logger.error("Error fetching profile with id: {}", id, e);
            throw e;
        }
    }

    @PutMapping("/profiles/{id}")
    public ResponseEntity<ProfileDTO> updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) {
        logger.info("Updating profile with id: {} with data: {}", id, profileDTO);
        try {
            ProfileDTO updated = profileService.updateProfile(id, profileDTO);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            logger.error("Error updating profile with id: {}", id, e);
            throw e;
        }
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        logger.info("Deleting profile with id: {}", id);
        try {
            profileService.deleteProfile(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting profile with id: {}", id, e);
            throw e;
        }
    }

    @GetMapping("/activate")
    public ResponseEntity<String> activateProfile(@RequestParam String activationCode) {
        logger.info("Activating profile with code: {}", activationCode);
        try {
            boolean activated = profileService.activateProfile(activationCode);
            if (activated) {
                return ResponseEntity.ok("Profile activated successfully");
            } else {
                return ResponseEntity.badRequest().body("Invalid activation code");
            }
        } catch (Exception e) {
            logger.error("Error activating profile with code: {}", activationCode, e);
            throw e;
        }
    }

}
