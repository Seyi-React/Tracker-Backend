package com.oluwaseyi.tracker.service.impl;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oluwaseyi.tracker.entity.DTO.ProfileDTO;
import com.oluwaseyi.tracker.repository.ProfileRepository;
import com.oluwaseyi.tracker.service.ProfileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {
        private static final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);

    private final ProfileRepository profileRepository;

    @Override
        public ProfileDTO createProfile(ProfileDTO profileDTO) {
                logger.info("Creating profile: {}", profileDTO);
                // if (profileRepository.findByEmail(profileDTO.getEmail())) {
                //         logger.warn("Email already in use: {}", profileDTO.getEmail());
                //         throw new IllegalArgumentException("Email already in use");
                // }
                com.oluwaseyi.tracker.entity.ProfileEntity profileEntity = com.oluwaseyi.tracker.entity.ProfileEntity.builder()
                                .email(profileDTO.getEmail())
                                .name(profileDTO.getName())
                                .phoneNumber(profileDTO.getPhoneNumber())
                                .profileImageUrl(profileDTO.getProfileImageUrl())
                                .password(profileDTO.getPassword())
                                .isActive(profileDTO.getIsActive())
                                .activationCode(java.util.UUID.randomUUID().toString())
                                .build();
                com.oluwaseyi.tracker.entity.ProfileEntity savedEntity = profileRepository.save(profileEntity);
                logger.info("Profile saved: {}", savedEntity);
                return ProfileDTO.builder()
                                .email(savedEntity.getEmail())
                                .phoneNumber(savedEntity.getPhoneNumber())
                                .name(savedEntity.getName())
                                .profileImageUrl(savedEntity.getProfileImageUrl())
                                .isActive(savedEntity.getIsActive())
                                .activationCode(savedEntity.getActivationCode())
                                .build();
    }

    @Override
    public ProfileDTO getProfileById(Long id) {
        logger.info("Getting profile by id: {}", id);
        com.oluwaseyi.tracker.entity.ProfileEntity entity = profileRepository.findById(id)
                .orElseThrow(() -> new com.oluwaseyi.tracker.exception.ResourceNotFoundException(
                        "Profile not found with id: " + id));
        logger.info("Found profile: {}", entity);
        return ProfileDTO.builder()
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .name(entity.getName())
                .profileImageUrl(entity.getProfileImageUrl())
                .isActive(entity.getIsActive())
                .activationCode(entity.getActivationCode())
                .build();
    }

    @Override
    public ProfileDTO updateProfile(Long id, ProfileDTO profileDTO) {
        logger.info("Updating profile id: {} with data: {}", id, profileDTO);
        com.oluwaseyi.tracker.entity.ProfileEntity entity = profileRepository.findById(id)
                .orElseThrow(() -> new com.oluwaseyi.tracker.exception.ResourceNotFoundException(
                        "Profile not found with id: " + id));
        entity.setEmail(profileDTO.getEmail());
        entity.setPhoneNumber(profileDTO.getPhoneNumber());
        entity.setName(profileDTO.getName());
        entity.setProfileImageUrl(profileDTO.getProfileImageUrl());
        entity.setIsActive(profileDTO.getIsActive());
        entity.setActivationCode(profileDTO.getActivationCode());
        com.oluwaseyi.tracker.entity.ProfileEntity updated = profileRepository.save(entity);
        logger.info("Profile updated: {}", updated);
        return ProfileDTO.builder()
                .email(updated.getEmail())
                .phoneNumber(updated.getPhoneNumber())
                .name(updated.getName())
                .profileImageUrl(updated.getProfileImageUrl())
                .isActive(updated.getIsActive())
                .activationCode(updated.getActivationCode())
                .build();
    }

    @Override
        public void deleteProfile(Long id) {
                logger.info("Deleting profile id: {}", id);
                com.oluwaseyi.tracker.entity.ProfileEntity entity = profileRepository.findById(id)
                                .orElseThrow(() -> new com.oluwaseyi.tracker.exception.ResourceNotFoundException(
                                                "Profile not found with id: " + id));
                profileRepository.delete(entity);
                logger.info("Profile deleted: {}", id);
    }

}
