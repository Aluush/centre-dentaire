package com.projet1.demo.services;


import com.projet1.demo.entities.DentistEntity;
import java.util.List;

public interface DentistService {
    List<DentistEntity> getAllDentists();
    DentistEntity getDentistById(Long id);
    DentistEntity createDentist(DentistEntity dentist);
    DentistEntity updateDentist(Long id, DentistEntity dentist);
    void deleteDentist(Long id);
}
