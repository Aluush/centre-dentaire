package com.projet1.demo.services;

import com.projet1.demo.entities.PrescriptionEntity;
import com.projet1.demo.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public List<PrescriptionEntity> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    public PrescriptionEntity getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));
    }

    @Override
    public PrescriptionEntity createPrescription(PrescriptionEntity prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public PrescriptionEntity updatePrescription(Long id, PrescriptionEntity prescription) {
        PrescriptionEntity existingPrescription = getPrescriptionById(id);
        existingPrescription.setMedication(prescription.getMedication());
        existingPrescription.setDosage(prescription.getDosage());
        existingPrescription.setInstructions(prescription.getInstructions());
        existingPrescription.setMedicalRecord(prescription.getMedicalRecord());
        return prescriptionRepository.save(existingPrescription);
    }

    @Override
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
