package com.portal.developer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperResponse {

    private Long id;
    private String fullName;
    private String email;
    private String companyName;
    private String organization;
    private String phoneNumber;
    private boolean active;

}