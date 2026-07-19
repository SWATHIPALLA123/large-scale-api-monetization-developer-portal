package com.portal.developer.dto;

import lombok.Data;

@Data
public class UpdateDeveloperRequest {

    private String fullName;
    private String companyName;
    private String organization;
    private String phoneNumber;

}