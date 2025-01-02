package com.projet1.demo.controllers;

import com.projet1.demo.entities.MedicalRecordEntity;
import com.projet1.demo.entities.PrescriptionEntity;
import com.projet1.demo.services.MedicalRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical")
public class MedicalRecordController {

    @Autowired
    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    // Récupérer toutes les prescriptions pour un patient
    @GetMapping("/patients/{patientId}/prescriptions")
    public List<PrescriptionEntity> getPrescriptions(@PathVariable Long patientId) {
        return medicalRecordService.getPrescriptions(patientId);
    }

    // Ajouter une nouvelle prescription pour un patient
    @PostMapping("/patients/{patientId}/prescriptions")
    public PrescriptionEntity createPrescription(@PathVariable Long patientId, @RequestBody PrescriptionEntity prescriptionDto) {
        return medicalRecordService.addPrescription(patientId, prescriptionDto);
    }

    // Récupérer le dossier médical d'un patient
    @GetMapping("/patients/{patientId}/medical-record")
    public MedicalRecordEntity getMedicalRecord(@PathVariable Long patientId) {
        return medicalRecordService.getMedicalRecord(patientId);
    }

    // Mettre à jour le dossier médical d'un patient
    @PutMapping("/patients/{patientId}/medical-record")
    public MedicalRecordEntity updateMedicalRecord(@PathVariable Long patientId, @RequestBody MedicalRecordEntity medicalRecordDto) {
        return medicalRecordService.updateMedicalRecord(patientId, medicalRecordDto);
    }
}
