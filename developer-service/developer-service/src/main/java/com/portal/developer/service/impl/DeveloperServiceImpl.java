package com.portal.developer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portal.developer.dto.DeveloperResponse;
import com.portal.developer.dto.UpdateDeveloperRequest;
import com.portal.developer.entity.Developer;
import com.portal.developer.repository.DeveloperRepository;
import com.portal.developer.service.DeveloperService;
import com.portal.developer.client.AuthClient;
import com.portal.developer.dto.ProfileResponse;
@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final AuthClient authClient;

    public DeveloperServiceImpl(DeveloperRepository developerRepository,
            AuthClient authClient) {

this.developerRepository = developerRepository;
this.authClient = authClient;
}

    @Override
    public DeveloperResponse getProfile(String email) {

        Developer developer = developerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Developer not found"));

        return mapToResponse(developer);
    }

    @Override
    public DeveloperResponse updateProfile(String email, UpdateDeveloperRequest request) {

        Developer developer = developerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Developer not found"));

        developer.setFullName(request.getFullName());
        developer.setCompanyName(request.getCompanyName());
        developer.setOrganization(request.getOrganization());
        developer.setPhoneNumber(request.getPhoneNumber());

        developerRepository.save(developer);

        return mapToResponse(developer);
    }

    @Override
    public List<DeveloperResponse> getAllDevelopers() {

        return developerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
    }

    private DeveloperResponse mapToResponse(Developer developer) {

        return new DeveloperResponse(
                developer.getId(),
                developer.getFullName(),
                developer.getEmail(),
                developer.getCompanyName(),
                developer.getOrganization(),
                developer.getPhoneNumber(),
                developer.isActive()
        );
    }
    @Override
    public ProfileResponse getAuthProfile(String email) {
        return authClient.getProfile(email);
    }
}