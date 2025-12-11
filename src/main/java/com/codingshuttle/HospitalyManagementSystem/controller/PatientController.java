package com.codingshuttle.HospitalyManagementSystem.controller;

import com.codingshuttle.HospitalyManagementSystem.entity.Appointment;
import com.codingshuttle.HospitalyManagementSystem.entity.Insurance;
import com.codingshuttle.HospitalyManagementSystem.entity.Patient;
import com.codingshuttle.HospitalyManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatient(@RequestParam(defaultValue = "id") String name
            ,@RequestParam(defaultValue = "0") Integer page
            ,@RequestParam(defaultValue = "ASC") String sortBy){
        return patientService.getAllPatient(name,page,sortBy);
    }
    @GetMapping("/{patientId}")
    public Optional<Patient> getPatientById(@PathVariable Long patientId){
        return patientService.getPatientById(patientId);
    }
    
    @GetMapping("/{patientId}/appointments")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long patientId) {
        return patientService.getAppointmentsByPatientId(patientId);
    }
    
    @GetMapping("/{patientId}/insurance")
    public Insurance getInsuranceByPatientId(@PathVariable Long patientId) {
        return patientService.getInsuranceByPatientId(patientId);
    }
    
    @PostMapping
    public Patient createPatient(@RequestBody Patient newPatient){
        return patientService.createPatient(newPatient);
    }
    @PutMapping("/{patientId}")
    public Patient updatePatientsDetails(@RequestBody Patient newPatient,@PathVariable Long patientId){
        return patientService.updatePatientDetails(newPatient,patientId);
    }
    @DeleteMapping("/{patientId}")
    public boolean deleteById(@PathVariable Long patientId){
        return patientService.deleteById(patientId);
    }
}