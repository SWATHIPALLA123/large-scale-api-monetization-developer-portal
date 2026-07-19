package com.portal.developer.service;

import java.util.List;

import com.portal.developer.dto.DeveloperResponse;
import com.portal.developer.dto.UpdateDeveloperRequest;
import com.portal.developer.dto.ProfileResponse;
public interface DeveloperService {

    DeveloperResponse getProfile(String email);
   
    DeveloperResponse updateProfile(String email,
                                    UpdateDeveloperRequest request);

    List<DeveloperResponse> getAllDevelopers();

    void deleteDeveloper(Long id);
    ProfileResponse getAuthProfile(String email);

}