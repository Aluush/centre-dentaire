package com.projet1.demo.controllers;

import com.projet1.demo.entities.MedicalRecordEntity;
import com.projet1.demo.entities.PrescriptionEntity;
import com.projet1.demo.services.MedicalRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/medical")
public class MedicalRecordController {

    @Autowired
    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping("/patients/{patientId}/prescriptions")
    public String getPrescriptions(@PathVariable Long patientId, Model model) {
        List<PrescriptionEntity> prescriptions = medicalRecordService.getPrescriptions(patientId);
        model.addAttribute("prescriptions", prescriptions);
        model.addAttribute("patientId", patientId);
        return "prescriptions";
    }

    @GetMapping("/patients/{patientId}/prescriptions/new")
    public String showCreatePrescriptionForm(@PathVariable Long patientId, Model model) {
        model.addAttribute("patientId", patientId);
        model.addAttribute("prescription", new PrescriptionEntity());
        return "create-prescription";
    }

    @PostMapping("/patients/{patientId}/prescriptions")
    public String createPrescription(@PathVariable Long patientId, @ModelAttribute PrescriptionEntity prescriptionDto) {
        medicalRecordService.addPrescription(patientId, prescriptionDto);
        return "redirect:/medical/patients/" + patientId + "/prescriptions";
    }

    @GetMapping("/patients/{patientId}/medical-record")
    public String getMedicalRecord(@PathVariable Long patientId, Model model) {
        MedicalRecordEntity medicalRecord = medicalRecordService.getMedicalRecord(patientId);
        model.addAttribute("medicalRecord", medicalRecord);
        model.addAttribute("patientId", patientId);
        return "medical-record";
    }

    @GetMapping("/patients/{patientId}/medical-record/edit")
    public String showEditMedicalRecordForm(@PathVariable Long patientId, Model model) {
        MedicalRecordEntity medicalRecord = medicalRecordService.getMedicalRecord(patientId);
        model.addAttribute("medicalRecord", medicalRecord);
        model.addAttribute("patientId", patientId);
        return "edit-medical-record";
    }

    @PostMapping("/patients/{patientId}/medical-record")
    public String updateMedicalRecord(@PathVariable Long patientId, @ModelAttribute MedicalRecordEntity medicalRecordDto) {
        medicalRecordService.updateMedicalRecord(patientId, medicalRecordDto);
        return "redirect:/medical/patients/" + patientId + "/medical-record";
    }
}