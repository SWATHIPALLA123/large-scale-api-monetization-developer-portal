package com.portal.developer.client;

import org.springframework.cloud.openfeign.FeignClient; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portal.developer.dto.ProfileResponse;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthClient {

	@GetMapping("/auth/profile")
	ProfileResponse getProfile(@RequestParam("email") String email);
}