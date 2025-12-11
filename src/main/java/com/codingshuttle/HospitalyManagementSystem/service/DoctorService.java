package com.codingshuttle.HospitalyManagementSystem.service;

import com.codingshuttle.HospitalyManagementSystem.entity.Appointment;
import com.codingshuttle.HospitalyManagementSystem.entity.Department;
import com.codingshuttle.HospitalyManagementSystem.entity.Doctor;
import com.codingshuttle.HospitalyManagementSystem.repository.AppointmentRepository;
import com.codingshuttle.HospitalyManagementSystem.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor createDoctor(Doctor newDoctor) {
        return doctorRepository.save(newDoctor);
    }

    public Doctor updateDoctor(Long doctorId, Doctor updatedDoctor) {
        updatedDoctor.setId(doctorId);
        return doctorRepository.save(updatedDoctor);
    }

    public boolean deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
        return true;
    }
    
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }
    
    public Department getDepartmentWhereDoctorIsHead(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        return doctor.getDepartment();
    }
}