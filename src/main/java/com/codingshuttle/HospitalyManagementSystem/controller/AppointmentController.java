package com.codingshuttle.HospitalyManagementSystem.controller;

import com.codingshuttle.HospitalyManagementSystem.entity.Appointment;
import com.codingshuttle.HospitalyManagementSystem.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAllAppointment();
    }

    @GetMapping("/{appointmentId}")
    public Optional<Appointment> getAppointmentById(@PathVariable Long appointmentId){
        return appointmentService.getAppointmentById(appointmentId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

    @PostMapping("/{patientId}/{doctorId}")
    public Appointment createAppointment(@RequestBody Appointment newAppointment, @PathVariable Long patientId, @PathVariable Long doctorId){
       Appointment appointment= appointmentService.createNewAppointment(newAppointment,patientId,doctorId);
        return appointment;
    }

    @DeleteMapping("/{appointmentId}")
    public boolean deleteAppointment(@PathVariable Long appointmentId){
           return appointmentService.deleteAppointment(appointmentId);
    }
}