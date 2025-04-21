package com.example.donationservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Campagne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campaign name cannot be empty")
    private String nom;

    @Positive(message = "Target amount must be positive")
    private BigDecimal objectifMontant;

    private LocalDate dateDebut;

    private LocalDate dateFin;
}