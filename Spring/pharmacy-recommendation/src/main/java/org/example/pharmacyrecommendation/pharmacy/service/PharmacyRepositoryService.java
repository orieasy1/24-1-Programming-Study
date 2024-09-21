package org.example.pharmacyrecommendation.pharmacy.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pharmacyrecommendation.pharmacy.entity.Pharmacy;
import org.example.pharmacyrecommendation.pharmacy.repository.PharmacyRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PharmacyRepositoryService {
    private final PharmacyRepository pharmacyRepository;

    @Transactional
    public void updateAddress(Long id, String address) {
        Pharmacy entity = pharmacyRepository.findById(id).orElse(null);

        if(Objects.isNull(entity)) {
            log.error("[PharmacyRepositoryService updateAddress] not found id: {}", id);
            return;
        }

        entity.changePharmacyAddress(address);
    }
}
