package com.projet1.demo.controllers;

import com.projet1.demo.entities.TreatmentSheetEntity;
import com.projet1.demo.services.TreatmentSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatment-sheets")
public class TreatmentSheetController {

    @Autowired
    private TreatmentSheetService treatmentSheetService;

    // Get all treatment sheets
    @GetMapping
    public List<TreatmentSheetEntity> getAllTreatmentSheets() {
        return treatmentSheetService.getAllTreatmentSheets();
    }

    // Get a treatment sheet by ID
    @GetMapping("/{id}")
    public TreatmentSheetEntity getTreatmentSheetById(@PathVariable Long id) {
        return treatmentSheetService.getTreatmentSheetById(id);
    }

    // Create a new treatment sheet
    @PostMapping
    public TreatmentSheetEntity createTreatmentSheet(@RequestBody TreatmentSheetEntity treatmentSheet) {
        return treatmentSheetService.createTreatmentSheet(treatmentSheet);
    }

    // Update a treatment sheet
    @PutMapping("/{id}")
    public TreatmentSheetEntity updateTreatmentSheet(@PathVariable Long id, @RequestBody TreatmentSheetEntity treatmentSheet) {
        return treatmentSheetService.updateTreatmentSheet(id, treatmentSheet);
    }

    // Delete a treatment sheet
    @DeleteMapping("/{id}")
    public void deleteTreatmentSheet(@PathVariable Long id) {
        treatmentSheetService.deleteTreatmentSheet(id);
    }
}
