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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProfileById'");
    }

    @Override
    public ProfileDTO updateProfile(Long id, ProfileDTO profileDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProfile'");
    }

    @Override
    public void deleteProfile(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProfile'");
    }

}
