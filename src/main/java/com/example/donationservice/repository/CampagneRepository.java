package com.example.donationservice.repository;

import com.example.donationservice.entity.Campagne;
import com.example.donationservice.projection.CampagneResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CampagneRepository extends JpaRepository<Campagne, Long> {
    @Query("SELECT c FROM Campagne c WHERE c.dateDebut <= CURRENT_DATE AND c.dateFin >= CURRENT_DATE")
    List<CampagneResume> findActiveCampagnes();
}