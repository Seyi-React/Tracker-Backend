package com.oluwaseyi.tracker.service;

import com.oluwaseyi.tracker.entity.DTO.ProfileDTO;

public interface ProfileService {

    ProfileDTO createProfile(ProfileDTO profileDTO);

    ProfileDTO getProfileById(Long id);

    ProfileDTO updateProfile(Long id, ProfileDTO profileDTO);

    void deleteProfile(Long id);


    boolean activateProfile(String activationCode);

}
