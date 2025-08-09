package com.oluwaseyi.tracker.service.impl;

import org.springframework.stereotype.Service;

import com.oluwaseyi.tracker.entity.DTO.ProfileDTO;
import com.oluwaseyi.tracker.repository.ProfileRepository;
import com.oluwaseyi.tracker.service.ProfileService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {
    
    private final ProfileRepository profileRepository;
    
    
    
    
    @Override
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
      if(profileRepository.findByEmail(profileDTO.getEmail())) {
          throw new IllegalArgumentException("Email already in use");
      }
      com.oluwaseyi.tracker.entity.ProfileEntity profileEntity = com.oluwaseyi.tracker.entity.ProfileEntity.builder()
          .email(profileDTO.getEmail())
          .phoneNumber(profileDTO.getPhoneNumber())
          .profileImageUrl(profileDTO.getProfileImageUrl())
          .isActive(profileDTO.getIsActive())
          .activationCode(java.util.UUID.randomUUID().toString())
          .build();
      com.oluwaseyi.tracker.entity.ProfileEntity savedEntity = profileRepository.save(profileEntity);
      return ProfileDTO.builder()
          .email(savedEntity.getEmail())
          .phoneNumber(savedEntity.getPhoneNumber())
          .profileImageUrl(savedEntity.getProfileImageUrl())
          .isActive(savedEntity.getIsActive())
          .activationCode(savedEntity.getActivationCode())
          .build();
    }

    @Override
    public ProfileDTO getProfileById(Long id) {
        com.oluwaseyi.tracker.entity.ProfileEntity entity = profileRepository.findById(id)
            .orElseThrow(() -> new com.oluwaseyi.tracker.exception.ResourceNotFoundException("Profile not found with id: " + id));
        return ProfileDTO.builder()
            .email(entity.getEmail())
            .phoneNumber(entity.getPhoneNumber())
            .profileImageUrl(entity.getProfileImageUrl())
            .isActive(entity.getIsActive())
            .activationCode(entity.getActivationCode())
            .build();
    }

    @Override
    public ProfileDTO updateProfile(Long id, ProfileDTO profileDTO) {
        com.oluwaseyi.tracker.entity.ProfileEntity entity = profileRepository.findById(id)
            .orElseThrow(() -> new com.oluwaseyi.tracker.exception.ResourceNotFoundException("Profile not found with id: " + id));
        entity.setEmail(profileDTO.getEmail());
        entity.setPhoneNumber(profileDTO.getPhoneNumber());
        entity.setProfileImageUrl(profileDTO.getProfileImageUrl());
        entity.setIsActive(profileDTO.getIsActive());
        entity.setActivationCode(profileDTO.getActivationCode());
        com.oluwaseyi.tracker.entity.ProfileEntity updated = profileRepository.save(entity);
        return ProfileDTO.builder()
            .email(updated.getEmail())
            .phoneNumber(updated.getPhoneNumber())
            .profileImageUrl(updated.getProfileImageUrl())
            .isActive(updated.getIsActive())
            .activationCode(updated.getActivationCode())
            .build();
    }

    @Override
    public void deleteProfile(Long id) {
        com.oluwaseyi.tracker.entity.ProfileEntity entity = profileRepository.findById(id)
            .orElseThrow(() -> new com.oluwaseyi.tracker.exception.ResourceNotFoundException("Profile not found with id: " + id));
        profileRepository.delete(entity);
    }

}
