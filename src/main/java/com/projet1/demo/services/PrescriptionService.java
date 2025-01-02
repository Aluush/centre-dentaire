package com.projet1.demo.services;

import com.projet1.demo.entities.PrescriptionEntity;

import java.util.List;

public interface PrescriptionService {
    List<PrescriptionEntity> getAllPrescriptions();
    PrescriptionEntity getPrescriptionById(Long id);
    PrescriptionEntity createPrescription(PrescriptionEntity prescription);
    PrescriptionEntity updatePrescription(Long id, PrescriptionEntity prescription);
    void deletePrescription(Long id);
}
