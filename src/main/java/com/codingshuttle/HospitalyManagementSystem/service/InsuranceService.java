package com.codingshuttle.HospitalyManagementSystem.service;

import com.codingshuttle.HospitalyManagementSystem.entity.Insurance;
import com.codingshuttle.HospitalyManagementSystem.entity.Patient;
import com.codingshuttle.HospitalyManagementSystem.repository.InsuranceRepository;
import com.codingshuttle.HospitalyManagementSystem.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance,long patientId){
        Patient patient= patientRepository.findById(patientId).orElse(null);

        patient.setInsurance(insurance);

        insurance.setPatient(patient);//optional
        return insurance;
    }

    @Transactional
    public Insurance updateInsuranceToPatient(Insurance insurance,long patientId){
        Patient patient= patientRepository.findById(patientId).orElse(null);

        patient.setInsurance(insurance);

        insurance.setPatient(patient);//optional
        return insurance;
    }

    @Transactional
    public Patient removeInsuranceToPatient(long patientId){
        Patient patient= patientRepository.findById(patientId).orElse(null);

        patient.setInsurance(null);
        return patient;
    }
    @Transactional
    public void deleteInsuranceToPatient(Long patientId){
        patientRepository.findById(patientId);
        patientRepository.deleteById(patientId);
    }

    @Transactional
    public Optional<Insurance> getInsuranceById(Long id){
        return insuranceRepository.findById(id);
    }

    @Transactional
    public List<Insurance> getAllInsurance(){
        return insuranceRepository.findAll();
    }
    
    public Patient getPatientByInsuranceId(Long insuranceId) {
        Insurance insurance = insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));
        return insurance.getPatient();
    }
}