package com.codingshuttle.HospitalyManagementSystem.repository;

import com.codingshuttle.HospitalyManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}