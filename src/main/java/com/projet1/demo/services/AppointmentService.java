package com.projet1.demo.services;

import com.projet1.demo.entities.AppointmentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    public List<AppointmentEntity> getAllAppointments() ;

    public AppointmentEntity scheduleAppointment(AppointmentEntity appointment) ;

    public Optional<AppointmentEntity> getAppointmentById(Long id);

    public void cancelAppointment(Long id) ;
}
