package com.codingshuttle.HospitalyManagementSystem;

import com.codingshuttle.HospitalyManagementSystem.entity.Department;
import com.codingshuttle.HospitalyManagementSystem.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDepartment {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void test(){
        Department department=departmentService.
    }
}
