package com.projet1.demo.services;

import com.projet1.demo.entities.DentistEntity;
import com.projet1.demo.repositories.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public List<DentistEntity> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public DentistEntity getDentistById(Long id) {
        return dentistRepository.findById(id).orElseThrow(() -> new RuntimeException("Dentist not found"));
    }

    @Override
    public DentistEntity createDentist(DentistEntity dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public DentistEntity updateDentist(Long id, DentistEntity dentist) {
        DentistEntity existingDentist = getDentistById(id);
        existingDentist.setName(dentist.getName());
        existingDentist.setSpecialty(dentist.getSpecialty());
        return dentistRepository.save(existingDentist);
    }

    @Override
    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);
    }
}
