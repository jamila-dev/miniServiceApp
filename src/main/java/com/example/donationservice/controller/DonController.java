package com.example.donationservice.controller;

import com.example.donationservice.dto.DonDTO;
import com.example.donationservice.exception.CampagneNotFoundException;
import com.example.donationservice.service.ServiceDon;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campagnes")
public class DonController {
    private final ServiceDon serviceDon;

    public DonController(ServiceDon serviceDon) {
        this.serviceDon = serviceDon;
    }

    @Operation(summary = "Create a donation", description = "Creates a new donation for a campaign")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Donation created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Campaign not found")
    })
    @PostMapping("/{id}/dons")
    @ResponseStatus(HttpStatus.CREATED)
    public DonDTO createDon(@PathVariable Long id, @Valid @RequestBody DonDTO donDTO) {
        return serviceDon.saveDon(id, donDTO);
    }

    @Operation(summary = "Get donations for a campaign", description = "Returns a list of donations for a specific campaign")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of donations"),
            @ApiResponse(responseCode = "404", description = "Campaign not found")
    })
    @GetMapping("/{id}/dons")
    public List<DonDTO> getDonationsByCampagneId(@PathVariable Long id) {
        return serviceDon.getDonationsByCampagneId(id);
    }
}