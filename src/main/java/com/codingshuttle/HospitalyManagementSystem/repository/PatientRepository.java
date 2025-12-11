package com.codingshuttle.HospitalyManagementSystem.repository;

import com.codingshuttle.HospitalyManagementSystem.dto.BloodGroupStatus;
import com.codingshuttle.HospitalyManagementSystem.dto.CPatientInfo;
import com.codingshuttle.HospitalyManagementSystem.dto.IPatientInfo;
import com.codingshuttle.HospitalyManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("select p.id as id,p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientInfo();

    @Query("SELECT new com.codingshuttle.HospitalyManagementSystem.dto.CPatientInfo(p.id,p.name) FROM Patient p")
    List<CPatientInfo> getAllPatientInfoConcrete();

    @Query("SELECT new com.codingshuttle.HospitalyManagementSystem.dto.BloodGroupStatus(p.bloodGroup,COUNT(p)) " +
            "from Patient p group by p.bloodGroup order by COUNT(p)")
    List<BloodGroupStatus> getAllPatientStatus();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p set p.name=?1 where p.id=?2")
    int updatePatientNameById(@Param("name") String name,@Param("id") Long id);

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
    public List<Patient> getAllPatientWithAppointment();
}
