package com.projet1.demo.services;

import com.projet1.demo.entities.AppointmentEntity;
import com.projet1.demo.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public AppointmentEntity scheduleAppointment(AppointmentEntity appointment) {
        return appointmentRepository.save(appointment);
    }

    public Optional<AppointmentEntity> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public void cancelAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
