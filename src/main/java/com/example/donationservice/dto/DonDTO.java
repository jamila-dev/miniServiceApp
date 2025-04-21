package com.example.donationservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class DonDTO {
    private Long id;

    @NotBlank(message = "Campaign name cannot be empty")
    private String nomCampagne;

    @NotBlank(message = "Donor name cannot be empty")
    private String nomDonateur;

    @Positive(message = "Donation amount must be positive")
    private BigDecimal montant;

    private LocalDateTime date;
}