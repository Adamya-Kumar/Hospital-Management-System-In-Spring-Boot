package com.codingshuttle.HospitalyManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // <--- This generates the constructor (Long id, String name)
@NoArgsConstructor
public class CPatientInfo {
    private Long id;
   private String name;
}
