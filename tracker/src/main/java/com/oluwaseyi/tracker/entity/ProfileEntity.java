package com.oluwaseyi.tracker.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profiles")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String phoneNumber;
    private String profileImageUrl;

    @Column(nullable = false, unique = true)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @Column(nullable = false, unique = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private Boolean isActive;
    private String activationCode;

    @PrePersist
    public void prePersist() {
        if (this.isActive == null) {
            this.isActive = false;
        }

    }

}
