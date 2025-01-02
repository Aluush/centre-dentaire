package com.projet1.demo.services;

import com.projet1.demo.entities.TreatmentSheetEntity;
import com.projet1.demo.repositories.TreatmentSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentSheetServiceImpl implements TreatmentSheetService {

    @Autowired
    private TreatmentSheetRepository treatmentSheetRepository;

    @Override
    public List<TreatmentSheetEntity> getAllTreatmentSheets() {
        return treatmentSheetRepository.findAll();
    }

    @Override
    public TreatmentSheetEntity getTreatmentSheetById(Long id) {
        return treatmentSheetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treatment sheet not found"));
    }

    @Override
    public TreatmentSheetEntity createTreatmentSheet(TreatmentSheetEntity treatmentSheet) {
        return treatmentSheetRepository.save(treatmentSheet);
    }

    @Override
    public TreatmentSheetEntity updateTreatmentSheet(Long id, TreatmentSheetEntity treatmentSheet) {
        TreatmentSheetEntity existingSheet = getTreatmentSheetById(id);
        existingSheet.setToothName(treatmentSheet.getToothName());
        existingSheet.setTreatmentDescription(treatmentSheet.getTreatmentDescription());
        existingSheet.setCost(treatmentSheet.getCost());
        existingSheet.setMedicalRecord(treatmentSheet.getMedicalRecord());
        return treatmentSheetRepository.save(existingSheet);
    }

    @Override
    public void deleteTreatmentSheet(Long id) {
        treatmentSheetRepository.deleteById(id);
    }
}
