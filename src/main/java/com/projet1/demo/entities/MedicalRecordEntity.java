package com.projet1.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "MedicalRecord")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    private List<PrescriptionEntity> prescriptions;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    private List<TreatmentSheetEntity> treatmentSheets;
}
