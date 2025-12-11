package com.codingshuttle.HospitalyManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(length = 100)
    private String specialization;
    @Column(nullable = false,length = 50,unique = true)
    private String email;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments=new HashSet<>();

    @OneToOne(mappedBy = "headDoctor",orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Department department;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
