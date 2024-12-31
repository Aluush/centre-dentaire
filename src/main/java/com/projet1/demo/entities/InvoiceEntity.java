package com.projet1.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Invoice")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private double amount;
    private boolean isPaid;

    @OneToOne
    @JoinColumn(name = "treatment_sheet_id")
    private TreatmentSheetEntity treatmentSheet;

    @OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
    private PaymentEntity payment;
}
