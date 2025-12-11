package com.codingshuttle.HospitalyManagementSystem.controller;

import com.codingshuttle.HospitalyManagementSystem.entity.Appointment;
import com.codingshuttle.HospitalyManagementSystem.entity.Department;
import com.codingshuttle.HospitalyManagementSystem.entity.Doctor;
import com.codingshuttle.HospitalyManagementSystem.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{doctorId}")
    public Optional<Doctor> getDoctorById(@PathVariable Long doctorId) {
        return doctorService.getDoctorById(doctorId);
    }
    
    @GetMapping("/{doctorId}/appointments")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        return doctorService.getAppointmentsByDoctorId(doctorId);
    }
    
    @GetMapping("/{doctorId}/department")
    public Department getDepartmentWhereDoctorIsHead(@PathVariable Long doctorId) {
        return doctorService.getDepartmentWhereDoctorIsHead(doctorId);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor newDoctor) {
        return doctorService.createDoctor(newDoctor);
    }

    @PutMapping("/{doctorId}")
    public Doctor updateDoctor(@RequestBody Doctor updatedDoctor, @PathVariable Long doctorId) {
        return doctorService.updateDoctor(doctorId, updatedDoctor);
    }

    @DeleteMapping("/{doctorId}")
    public boolean deleteDoctor(@PathVariable Long doctorId) {
        return doctorService.deleteDoctor(doctorId);
    }
}