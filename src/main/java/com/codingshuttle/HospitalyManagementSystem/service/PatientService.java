package com.codingshuttle.HospitalyManagementSystem.service;

import com.codingshuttle.HospitalyManagementSystem.entity.Appointment;
import com.codingshuttle.HospitalyManagementSystem.entity.Insurance;
import com.codingshuttle.HospitalyManagementSystem.entity.Patient;
import com.codingshuttle.HospitalyManagementSystem.repository.AppointmentRepository;
import com.codingshuttle.HospitalyManagementSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    
  public List<Patient> getAllPatient(String name, Integer page, String sortBy) {
      Sort.Direction direction = "desc".equalsIgnoreCase(sortBy) ? Sort.Direction.DESC : Sort.Direction.ASC;
      int pageNumber = (page == null || page < 0) ? 0 : page;
      Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by(direction, name));
      return patientRepository.findAll(pageable).getContent();
  }

    public Optional<Patient> getPatientById(Long id){
        return patientRepository.findById(id);
    }
    
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
    
    public Insurance getInsuranceByPatientId(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return patient.getInsurance();
    }

    public Patient createPatient(Patient newPatient) {
        return patientRepository.save(newPatient);
    }
    @Transactional
    public Patient updatePatientDetails(Patient newPatient,Long patientId) {
        patientRepository.findById(patientId);
        newPatient.setId(patientId);
        Patient savedPatient =patientRepository.save(newPatient);
        return savedPatient;
    }

    public boolean deleteById(Long patientId) {
        patientRepository.deleteById(patientId);
        return true;
    }
}