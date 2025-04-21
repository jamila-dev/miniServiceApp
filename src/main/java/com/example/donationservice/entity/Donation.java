package com.example.donationservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campagne_id", nullable = false)
    private Campagne campagne;

    @NotBlank(message = "Donor name cannot be empty")
    private String nomDonateur;

    @Positive(message = "Donation amount must be positive")
    private BigDecimal montant;

    private LocalDateTime date;
}