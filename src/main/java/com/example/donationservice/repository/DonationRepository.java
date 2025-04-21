package com.example.donationservice.repository;

import com.example.donationservice.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByCampagneId(Long campagneId);
}