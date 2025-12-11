package com.codingshuttle.HospitalyManagementSystem.repository;

import com.codingshuttle.HospitalyManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}