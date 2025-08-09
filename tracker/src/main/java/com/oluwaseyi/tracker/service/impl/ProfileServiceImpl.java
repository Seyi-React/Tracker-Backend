package com.oluwaseyi.tracker.service.impl;

import org.springframework.stereotype.Service;

import com.oluwaseyi.tracker.entity.DTO.ProfileDTO;
import com.oluwaseyi.tracker.service.ProfileService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {@Override
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProfile'");
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
