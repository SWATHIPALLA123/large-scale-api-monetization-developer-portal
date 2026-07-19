package com.portal.auth.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service;

import com.portal.auth.dto.AuthResponse;
import com.portal.auth.dto.LoginRequest;
import com.portal.auth.dto.ProfileResponse;
import com.portal.auth.dto.RegisterRequest;
import com.portal.auth.entity.Developer;
import com.portal.auth.entity.Role;
import com.portal.auth.entity.User;
import com.portal.auth.repository.DeveloperRepository;
import com.portal.auth.repository.RoleRepository;
import com.portal.auth.repository.UserRepository;
import com.portal.auth.security.JwtService;
import com.portal.auth.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final DeveloperRepository developerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           DeveloperRepository developerRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.developerRepository = developerRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Role role = roleRepository.findByRoleName("DEVELOPER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);
        user.setActive(true);

        User savedUser = userRepository.save(user);

        Developer developer = new Developer();
        developer.setCompanyName(request.getCompanyName());
        developer.setOrganization(request.getOrganization());
        developer.setPhoneNumber(request.getPhoneNumber());
        developer.setUser(savedUser);

        developerRepository.save(developer);

        return new AuthResponse(null, "User Registered Successfully");
    }
    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse(token, "Login Successful");
    }
    @Override
    public ProfileResponse getProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Developer developer = developerRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Developer not found"));

        return new ProfileResponse(
                user.getFullName(),
                user.getEmail(),
                user.getRole().getRoleName(),
                developer.getCompanyName(),
                developer.getOrganization(),
                developer.getPhoneNumber()
        );
    }
    }
