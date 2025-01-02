package com.projet1.demo.controllers;

import com.projet1.demo.entities.DentistEntity;
import com.projet1.demo.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    // Get all dentists
    @GetMapping
    public List<DentistEntity> getAllDentists() {
        return dentistService.getAllDentists();
    }

    // Get a dentist by ID
    @GetMapping("/{id}")
    public DentistEntity getDentistById(@PathVariable Long id) {
        return dentistService.getDentistById(id);
    }

    // Create a new dentist
    @PostMapping
    public DentistEntity createDentist(@RequestBody DentistEntity dentist) {
        return dentistService.createDentist(dentist);
    }

    // Update a dentist
    @PutMapping("/{id}")
    public DentistEntity updateDentist(@PathVariable Long id, @RequestBody DentistEntity dentist) {
        return dentistService.updateDentist(id, dentist);
    }

    // Delete a dentist
    @DeleteMapping("/{id}")
    public void deleteDentist(@PathVariable Long id) {
        dentistService.deleteDentist(id);
    }
}
