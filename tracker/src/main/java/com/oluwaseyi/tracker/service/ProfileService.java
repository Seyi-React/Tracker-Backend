package com.oluwaseyi.tracker.service;



import org.springframework.http.ResponseEntity;

import com.oluwaseyi.tracker.entity.DTO.LoginRequestDTO;
import com.oluwaseyi.tracker.entity.DTO.ProfileDTO;

public interface ProfileService {

    ProfileDTO createProfile(ProfileDTO profileDTO);

    ProfileDTO getProfileById(Long id);

    ProfileDTO updateProfile(Long id, ProfileDTO profileDTO);

    void deleteProfile(Long id);

    ResponseEntity<ProfileDTO> login(LoginRequestDTO loginRequest);

    boolean activateProfile(String activationCode);

}
