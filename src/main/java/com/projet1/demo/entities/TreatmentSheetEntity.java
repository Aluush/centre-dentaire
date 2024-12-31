package com.projet1.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "TreatmentSheet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TreatmentSheetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String toothName;
    private String treatmentDescription;
    private double cost;

    @ManyToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecordEntity medicalRecord;

    @OneToOne(mappedBy = "treatmentSheet", cascade = CascadeType.ALL)
    private InvoiceEntity invoice;
}
