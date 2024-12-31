package com.projet1.demo.services;

import com.projet1.demo.entities.MedicalRecordEntity;
import com.projet1.demo.entities.PatientEntity;
import com.projet1.demo.entities.PrescriptionEntity;

import java.util.List;

public interface MedicalRecordService {
    public List<PrescriptionEntity> getPrescriptions(Long medicalRecordId) ;

    public PrescriptionEntity addPrescription(Long medicalRecordId, PrescriptionEntity prescription);

    public MedicalRecordEntity getMedicalRecord(Long patientId) ;

    public MedicalRecordEntity updateMedicalRecord(Long patientId, MedicalRecordEntity medicalRecord) ;

}
