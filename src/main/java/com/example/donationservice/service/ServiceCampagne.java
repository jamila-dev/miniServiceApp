package com.example.donationservice.service;

import com.example.donationservice.entity.Campagne;
import com.example.donationservice.projection.CampagneResume;
import com.example.donationservice.repository.CampagneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCampagne {
    private final CampagneRepository campagneRepository;

    public ServiceCampagne(CampagneRepository campagneRepository) {
        this.campagneRepository = campagneRepository;
    }

    public List<CampagneResume> getActiveCampagnes() {
        return campagneRepository.findActiveCampagnes();
    }

    public List<Campagne> getAllCampagnes() {
        return campagneRepository.findAll();
    }
}