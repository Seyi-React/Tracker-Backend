package com.oluwaseyi.tracker.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oluwaseyi.tracker.entity.ProfileEntity;


public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

    Optional<ProfileEntity> findByEmail(String email);
}
 