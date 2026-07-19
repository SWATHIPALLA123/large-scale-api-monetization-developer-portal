package com.portal.developer.entity;

import jakarta.persistence.*; 
import lombok.*;

@Entity
@Table(name = "developers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String companyName;

    private String organization;

    private String phoneNumber;

    @Column(nullable = false)
    private boolean active;
}