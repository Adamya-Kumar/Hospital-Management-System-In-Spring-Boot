package com.codingshuttle.HospitalyManagementSystem.controller;

import com.codingshuttle.HospitalyManagementSystem.entity.Insurance;
import com.codingshuttle.HospitalyManagementSystem.entity.Patient;
import com.codingshuttle.HospitalyManagementSystem.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping("/{patientId}")
    public Insurance createInsuranceByPatiemtId(@RequestBody Insurance newInsurance,@PathVariable Long patientId){
       return insuranceService.assignInsuranceToPatient(newInsurance,patientId);
    }

    @GetMapping
    public List<Insurance> getAllInsurance(){
       return insuranceService.getAllInsurance();
    }

    @GetMapping("/{insuranceId}")
    public Optional<Insurance> getInsuranceById(@PathVariable Long insuranceId){
       return insuranceService.getInsuranceById(insuranceId);
    }
    
    @GetMapping("/{insuranceId}/patient")
    public Patient getPatientByInsuranceId(@PathVariable Long insuranceId) {
        return insuranceService.getPatientByInsuranceId(insuranceId);
    }

    @PatchMapping("/{patientId}")
    public Insurance updateInsuranceToPatient(@RequestBody Insurance newInsurance,@PathVariable Long patientId){
        return insuranceService.updateInsuranceToPatient(newInsurance,patientId);
    }
    @DeleteMapping("/removeInsurance/{patientId}")
    public Patient removeInsuranceToPatient(@PathVariable Long patientId){
        return insuranceService.removeInsuranceToPatient(patientId);
    }

}