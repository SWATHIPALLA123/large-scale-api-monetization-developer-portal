package com.portal.developer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.portal.developer.dto.ProfileResponse;
import com.portal.developer.dto.DeveloperResponse;
import com.portal.developer.dto.UpdateDeveloperRequest;
import com.portal.developer.service.DeveloperService;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<DeveloperResponse> getProfile(@PathVariable String email) {
        return ResponseEntity.ok(developerService.getProfile(email));
    }

    @PutMapping("/{email}")
    public ResponseEntity<DeveloperResponse> updateProfile(
            @PathVariable String email,
            @RequestBody UpdateDeveloperRequest request) {

        return ResponseEntity.ok(developerService.updateProfile(email, request));
    }

    @GetMapping
    public ResponseEntity<List<DeveloperResponse>> getAllDevelopers() {
        return ResponseEntity.ok(developerService.getAllDevelopers());
    }
    @GetMapping("/auth-profile")
    public ResponseEntity<ProfileResponse> getAuthProfile(
            @RequestParam String email) {

        return ResponseEntity.ok(
                developerService.getAuthProfile(email)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable Long id) {

        developerService.deleteDeveloper(id);

        return ResponseEntity.ok("Developer deleted successfully");
    }
}