package com.portal.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.auth.entity.Developer;
import com.portal.auth.entity.User;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Optional<Developer> findByUser(User user);

}