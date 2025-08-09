package com.oluwaseyi.tracker.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {


    private String email;
    private String phoneNumber;
    private String profileImageUrl;
    private Boolean isActive;
    private String activationCode;

}
