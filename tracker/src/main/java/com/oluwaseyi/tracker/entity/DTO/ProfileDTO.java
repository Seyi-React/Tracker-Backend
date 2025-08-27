package com.oluwaseyi.tracker.entity.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDTO {

    private String name;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String phoneNumber;
    private String profileImageUrl;
    private Boolean isActive;
    private String activationCode;
    private String token;
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String message;

}
