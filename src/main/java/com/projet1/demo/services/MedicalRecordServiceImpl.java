package com.projet1.demo.services;

import com.projet1.demo.entities.MedicalRecordEntity;
import com.projet1.demo.entities.PatientEntity;
import com.projet1.demo.entities.PrescriptionEntity;
import com.projet1.demo.repositories.MedicalRecordRepository;
import com.projet1.demo.repositories.PatientRepository;
import com.projet1.demo.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService{


    @Autowired
    private final MedicalRecordRepository medicalRecordRepository;
    @Autowired
    private final PrescriptionRepository prescriptionRepository;
    @Autowired
    private final PatientRepository patientRepository;

    public MedicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository, PrescriptionRepository prescriptionRepository, PatientRepository patientRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.patientRepository = patientRepository;
    }


    public List<PrescriptionEntity> getPrescriptions(Long medicalRecordId) {
        MedicalRecordEntity medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElse(null);
        if (medicalRecord != null) {
            return medicalRecord.getPrescriptions();
        }
        return null;
    }

    public PrescriptionEntity addPrescription(Long medicalRecordId, PrescriptionEntity prescription) {
        MedicalRecordEntity medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElse(null);
        if (medicalRecord != null) {
            prescription.setMedicalRecord(medicalRecord);
            return prescriptionRepository.save(prescription);
        }
        return null;
    }

    public MedicalRecordEntity getMedicalRecord(Long patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    public MedicalRecordEntity updateMedicalRecord(Long patientId, MedicalRecordEntity medicalRecord) {
        MedicalRecordEntity existingRecord = medicalRecordRepository.findByPatientId(patientId);

        PatientEntity p = patientRepository.findById(patientId).orElse(null);
        if (existingRecord == null) {
            medicalRecord.setPatient(p);
            return medicalRecordRepository.save(medicalRecord);
        }

        existingRecord.setPrescriptions(medicalRecord.getPrescriptions());
        existingRecord.setTreatmentSheets(medicalRecord.getTreatmentSheets());
        return medicalRecordRepository.save(existingRecord);
    }


}
