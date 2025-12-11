package com.codingshuttle.HospitalyManagementSystem;

import com.codingshuttle.HospitalyManagementSystem.entity.Insurance;
import com.codingshuttle.HospitalyManagementSystem.service.InsuranceService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private  InsuranceService insuranceService;

    @Test
    public void testAssignInsuranceToPatient(){
        Insurance insurance=Insurance.builder()
                .provider("HDFC Bank")
                .policyNumber("HDFC8478393")
                .validUntil(String.valueOf(LocalDate.of(2030,12,11)))
                .build();
        var updateInsurance=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(updateInsurance);


        var afterRemove=insuranceService.removeInsuranceToPatient(1L);
        System.out.println(afterRemove);
    }

    @Test
    public void testDeleteInsuranceToPatient(){
        insuranceService.deleteInsuranceToPatient(1L);
    }
}
