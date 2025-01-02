package com.projet1.demo.services;

import com.projet1.demo.entities.TreatmentSheetEntity;

import java.util.List;

public interface TreatmentSheetService {
    List<TreatmentSheetEntity> getAllTreatmentSheets();
    TreatmentSheetEntity getTreatmentSheetById(Long id);
    TreatmentSheetEntity createTreatmentSheet(TreatmentSheetEntity treatmentSheet);
    TreatmentSheetEntity updateTreatmentSheet(Long id, TreatmentSheetEntity treatmentSheet);
    void deleteTreatmentSheet(Long id);
}
