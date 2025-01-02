package com.projet1.demo.controllers;

import com.projet1.demo.entities.PrescriptionEntity;
import com.projet1.demo.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // Get all prescriptions
    @GetMapping
    public List<PrescriptionEntity> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    // Get a prescription by ID
    @GetMapping("/{id}")
    public PrescriptionEntity getPrescriptionById(@PathVariable Long id) {
        return prescriptionService.getPrescriptionById(id);
    }

    // Create a new prescription
    @PostMapping
    public PrescriptionEntity createPrescription(@RequestBody PrescriptionEntity prescription) {
        return prescriptionService.createPrescription(prescription);
    }

    // Update a prescription
    @PutMapping("/{id}")
    public PrescriptionEntity updatePrescription(@PathVariable Long id, @RequestBody PrescriptionEntity prescription) {
        return prescriptionService.updatePrescription(id, prescription);
    }

    // Delete a prescription
    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
    }
}
