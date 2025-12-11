package com.codingshuttle.HospitalyManagementSystem.service;

import com.codingshuttle.HospitalyManagementSystem.entity.Department;
import com.codingshuttle.HospitalyManagementSystem.entity.Doctor;
import com.codingshuttle.HospitalyManagementSystem.exception.ResourceNotFoundException;
import com.codingshuttle.HospitalyManagementSystem.repository.DepartmentRepository;
import com.codingshuttle.HospitalyManagementSystem.repository.DoctorRepository;
import jakarta.transaction.TransactionScoped;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    public List<Department> getAllDepartment(String name,Integer page){
        Pageable pageable=PageRequest.of(page,10, Sort.by(name));
        return departmentRepository.findAll(pageable).getContent();
    }
    
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }
    
    public Doctor getHeadDoctorOfDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found!"));
        return department.getHeadDoctor();
    }

    @Transactional
    public Department createDepartment(Department newDepartment,Long id) {
       Doctor doctor =doctorRepository.findById(id).orElse(null);
       if(doctor == null) throw  new ResourceNotFoundException("Resource not found!");
       newDepartment.setHeadDoctor(doctor);
      return departmentRepository.save(newDepartment);
    }

  @Transactional
  public Department addDoctorInDepartment(Long doctorId, Long departmentId) {
      Doctor doctor = doctorRepository.findById(doctorId)
              .orElseThrow(() -> new ResourceNotFoundException("Doctor not found!"));
      Department department = departmentRepository.findById(departmentId)
              .orElseThrow(() -> new ResourceNotFoundException("Department not found!"));

      if (department.getDoctors() == null) {
          department.setDoctors(new java.util.HashSet<>());
      }

      department.getDoctors().add(doctor);
      doctor.setDepartment(department);
      doctorRepository.save(doctor);
      return departmentRepository.save(department);
  }

  @Transactional
    public Set<Doctor> getDoctorPresentInDepartment(Long departmentId){
        Department department=departmentRepository.findById(departmentId).orElse(null);
       Set<Doctor> doctors=department.getDoctors();
        return doctors;
    }
}