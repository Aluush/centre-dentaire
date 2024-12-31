package com.projet1.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Patient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private MedicalRecordEntity medicalRecord;

}
