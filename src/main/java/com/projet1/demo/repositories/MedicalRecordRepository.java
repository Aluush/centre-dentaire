package com.projet1.demo.repositories;

import com.projet1.demo.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecordEntity, Long> {
    MedicalRecordEntity findByPatientId(Long patientId);
    MedicalRecordEntity save(MedicalRecordEntity medicalRecord);
}