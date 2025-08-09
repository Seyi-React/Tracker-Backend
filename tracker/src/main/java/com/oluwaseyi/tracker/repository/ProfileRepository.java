package com.oluwaseyi.tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oluwaseyi.tracker.entity.ProfileEntity;
import com.oluwaseyi.tracker.entity.DTO.ProfileDTO;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
  
    boolean findByEmail(String email);
}
 