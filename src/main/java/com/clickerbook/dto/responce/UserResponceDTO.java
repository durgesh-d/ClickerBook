package com.clickerbook.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponceDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String mobileNumber;

    private String bio;

    private String profileImage;

    private String coverImage;

    private Boolean privateAccount;

    private String role;

    private String status;

    private LocalDateTime createdAt;
}