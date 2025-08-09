package com.oluwaseyi.tracker.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.oluwaseyi.tracker.entity.ProfileEntity;


public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
  
    boolean findByEmail(String email);
}
 