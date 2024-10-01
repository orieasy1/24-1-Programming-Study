package org.example.pharmacyrecommendation.pharmacy.repository;

import org.example.pharmacyrecommendation.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
