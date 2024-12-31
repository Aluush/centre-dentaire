package com.projet1.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Prescription")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medication;
    private String dosage;
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecordEntity medicalRecord;

}
