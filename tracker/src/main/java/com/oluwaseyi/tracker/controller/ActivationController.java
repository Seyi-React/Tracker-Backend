package com.oluwaseyi.tracker.controller;

import com.oluwaseyi.tracker.repository.ProfileRepository;
import com.oluwaseyi.tracker.entity.ProfileEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/activate")
public class ActivationController {
    private final ProfileRepository profileRepository;

    @PostMapping
    public ResponseEntity<String> activate(@RequestParam String email, @RequestParam String code) {
        ProfileEntity profile = profileRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("No profile found for email"));
        if (profile.getActivationCode().equals(code)) {
            profile.setIsActive(true);
            profileRepository.save(profile);
            return ResponseEntity.ok("Account activated successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid activation code");
        }
    }
}
