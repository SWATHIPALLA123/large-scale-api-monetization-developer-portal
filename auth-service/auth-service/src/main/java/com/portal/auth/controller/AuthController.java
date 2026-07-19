package com.portal.auth.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.portal.auth.dto.AuthResponse;
import com.portal.auth.dto.LoginRequest;
import com.portal.auth.dto.RegisterRequest;
import com.portal.auth.service.AuthService;
import org.springframework.security.core.Authentication;
import com.portal.auth.dto.ProfileResponse;
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
    @GetMapping("/profile")
    public ResponseEntity<ProfileResponse> profile(
            @RequestParam String email) {

        return ResponseEntity.ok(
                authService.getProfile(email)
        );
    }
}