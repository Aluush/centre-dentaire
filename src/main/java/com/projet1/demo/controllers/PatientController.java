package com.projet1.demo.controllers;

import com.projet1.demo.entities.PatientEntity;
import com.projet1.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private  PatientService patientService;


    @GetMapping
    public List<PatientEntity> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    public PatientEntity addPatient(@RequestBody PatientEntity patient) {
        return patientService.addPatient(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientEntity> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
