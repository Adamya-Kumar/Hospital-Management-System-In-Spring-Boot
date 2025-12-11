package com.codingshuttle.HospitalyManagementSystem;

import com.codingshuttle.HospitalyManagementSystem.entity.Appointment;
import com.codingshuttle.HospitalyManagementSystem.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateNewAppointment(){
        Appointment appointment=Appointment.builder()
                .appointmentTime("2025-01-11")
                .reason("Caner")
                .build();

        appointmentService.createNewAppointment(appointment,2L,2L);
    }
    @Test
    public void testDeleteAppointment(){
       boolean success=appointmentService.deleteAppointment(1L);
        System.out.println(success);
    }
}
