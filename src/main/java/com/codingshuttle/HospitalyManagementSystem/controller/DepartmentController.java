package com.codingshuttle.HospitalyManagementSystem.controller;

import com.codingshuttle.HospitalyManagementSystem.entity.Department;
import com.codingshuttle.HospitalyManagementSystem.entity.Doctor;
import com.codingshuttle.HospitalyManagementSystem.service.DepartmentService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartment(@RequestParam(defaultValue = "id") String name,@RequestParam(defaultValue = "0") Integer page){
        return departmentService.getAllDepartment(name,page);
    }
    
    @GetMapping("/{departmentId}")
    public Optional<Department> getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }
    
    @GetMapping("/{departmentId}/headDoctor")
    public Doctor getHeadDoctorOfDepartment(@PathVariable Long departmentId) {
        return departmentService.getHeadDoctorOfDepartment(departmentId);
    }

    @PostMapping("/{doctorId}")
    public Department createDepartment(@RequestBody Department newDepartment,@PathVariable Long doctorId){
        return departmentService.createDepartment(newDepartment,doctorId);
    }

    @PutMapping("/{doctorId}/{departmentId}")
    public Department addDoctorInDepartment(@PathVariable Long doctorId,@PathVariable Long departmentId){
        return departmentService.addDoctorInDepartment(doctorId,departmentId);
    }
    @GetMapping("/{departmentId}/doctors")
    public Set<Doctor> getDoctorPresentInDepartment(@PathVariable Long departmentId){
        return departmentService.getDoctorPresentInDepartment(departmentId);
    }
}