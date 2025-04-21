package com.example.donationservice.controller;

import com.example.donationservice.entity.Campagne;
import com.example.donationservice.projection.CampagneResume;
import com.example.donationservice.service.ServiceCampagne;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/campagnes")
public class CampagneController {
    private final ServiceCampagne serviceCampagne;

    public CampagneController(ServiceCampagne serviceCampagne) {
        this.serviceCampagne = serviceCampagne;
    }

    @Operation(summary = "Get active campaigns", description = "Returns a list of active campaigns")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of active campaigns")
    })
    @GetMapping("/actives")
    public List<CampagneResume> getActiveCampagnes() {
        return serviceCampagne.getActiveCampagnes();
    }

    @Operation(summary = "Get all campaigns", description = "Returns a list of all campaigns")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of all campaigns")
    })
    @GetMapping
    public List<Campagne> getAllCampagnes() {
        return serviceCampagne.getAllCampagnes();
    }
}