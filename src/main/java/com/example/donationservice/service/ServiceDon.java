package com.example.donationservice.service;

import com.example.donationservice.dto.DonDTO;
import com.example.donationservice.entity.Campagne;
import com.example.donationservice.entity.Donation;
import com.example.donationservice.exception.CampagneNotFoundException;
import com.example.donationservice.repository.CampagneRepository;
import com.example.donationservice.repository.DonationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceDon {
    private final CampagneRepository campagneRepository;
    private final DonationRepository donationRepository;

    public ServiceDon(CampagneRepository campagneRepository, DonationRepository donationRepository) {
        this.campagneRepository = campagneRepository;
        this.donationRepository = donationRepository;
    }

    public DonDTO saveDon(Long campagneId, DonDTO donDTO) {
        Campagne campagne = campagneRepository.findById(campagneId)
                .orElseThrow(() -> new CampagneNotFoundException("Campaign not found with id: " + campagneId));
        Donation donation = new Donation();
        donation.setCampagne(campagne);
        donation.setNomDonateur(donDTO.getNomDonateur());
        donation.setMontant(donDTO.getMontant());
        donation.setDate(LocalDateTime.now());
        Donation savedDonation = donationRepository.save(donation);
        return toDonDTO(savedDonation);
    }

    public List<DonDTO> getDonationsByCampagneId(Long campagneId) {
        Campagne campagne = campagneRepository.findById(campagneId)
                .orElseThrow(() -> new CampagneNotFoundException("Campaign not found with id: " + campagneId));
        List<Donation> donations = donationRepository.findByCampagneId(campagneId);
        return donations.stream().map(this::toDonDTO).collect(Collectors.toList());
    }

    private DonDTO toDonDTO(Donation donation) {
        DonDTO donDTO = new DonDTO();
        donDTO.setId(donation.getId());
        donDTO.setNomCampagne(donation.getCampagne().getNom());
        donDTO.setNomDonateur(donation.getNomDonateur());
        donDTO.setMontant(donation.getMontant());
        donDTO.setDate(donation.getDate());
        return donDTO;
    }
}