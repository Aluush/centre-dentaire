package com.projet1.demo.services;

import com.projet1.demo.entities.PatientEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    public List<PatientEntity> getAllPatients() ;

    public PatientEntity addPatient(PatientEntity patient) ;

    public Optional<PatientEntity> getPatientById(Long id) ;

    public void deletePatient(Long id) ;
}
