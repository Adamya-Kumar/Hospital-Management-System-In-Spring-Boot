package com.codingshuttle.HospitalyManagementSystem.dto;

import com.codingshuttle.HospitalyManagementSystem.entity.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodGroupStatus {
    private BloodGroupType bloodGroup;
    private Long count;
}
