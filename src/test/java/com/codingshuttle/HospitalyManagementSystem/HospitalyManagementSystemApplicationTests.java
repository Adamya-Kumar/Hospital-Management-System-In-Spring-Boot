package com.codingshuttle.HospitalyManagementSystem;

import com.codingshuttle.HospitalyManagementSystem.dto.BloodGroupStatus;
import com.codingshuttle.HospitalyManagementSystem.dto.CPatientInfo;
import com.codingshuttle.HospitalyManagementSystem.dto.IPatientInfo;
import com.codingshuttle.HospitalyManagementSystem.entity.Patient;
import com.codingshuttle.HospitalyManagementSystem.repository.PatientRepository;
import com.codingshuttle.HospitalyManagementSystem.service.PatientService;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HospitalyManagementSystemApplicationTests {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;

    @Test
    void test(){
        List<Patient> patientList=patientRepository.getAllPatientWithAppointment();
        for(Patient p:patientList){
            System.out.println(p);
        }
    }

    @Test
    void testAllPatientByProjection(){
        List<IPatientInfo> patientInfoList=patientRepository.getAllPatientInfo();

        for(IPatientInfo p:patientInfoList){
            System.out.println(p);
        }
    }

    @Test
    void testAllPatientByDTOProjection(){
        List<CPatientInfo> patientInfoList=patientRepository.getAllPatientInfoConcrete();
        for(CPatientInfo p:patientInfoList){
            System.out.println(p);
        }
    }

    @Test
    void testAllPatientByStatus(){
        List<BloodGroupStatus> bloodGroupStatuses=patientRepository.getAllPatientStatus();
        for(BloodGroupStatus p:bloodGroupStatuses) {
            System.out.println(p);
        }
    }

    @Test
    void testUpdateNameById(){
        int rowAffeted=patientRepository.updatePatientNameById("Adamya Kumar",1L);
        System.out.println(rowAffeted);
    }

    @Test
    void testTransitionConetxt(){
        patientService.testTransistionContext();
    }

    @Test
    void testFetchAllPatients(){
        List<Patient> patientList=patientRepository.findAll();

        for(var p:patientList){
            System.out.println(p);
        }
    }

}
