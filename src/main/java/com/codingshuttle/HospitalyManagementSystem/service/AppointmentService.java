package com.codingshuttle.HospitalyManagementSystem.service;

import com.codingshuttle.HospitalyManagementSystem.entity.Appointment;
import com.codingshuttle.HospitalyManagementSystem.entity.Doctor;
import com.codingshuttle.HospitalyManagementSystem.entity.Patient;
import com.codingshuttle.HospitalyManagementSystem.exception.ResourceNotFoundException;
import com.codingshuttle.HospitalyManagementSystem.repository.AppointmentRepository;
import com.codingshuttle.HospitalyManagementSystem.repository.DoctorRepository;
import com.codingshuttle.HospitalyManagementSystem.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId){
        Patient patient =patientRepository.findById(patientId).orElse(null);
        Doctor doctor=doctorRepository.findById(doctorId).orElse(null);
        if(patient != null && doctor != null) {
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
        }else{
            throw new ResourceNotFoundException("Resource not found!");
        }

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public List<Appointment> getAllAppointment(){
        return appointmentRepository.findAll();
    }

    @Transactional
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Transactional
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Transactional
    public boolean deleteAppointment(Long appointmentId){
        appointmentRepository.findById(appointmentId);
        appointmentRepository.deleteById(appointmentId);
        return true;
    }

    @Transactional
    public Optional<Appointment> getAppointmentById(Long id){
       return appointmentRepository.findById(id);
    }
}