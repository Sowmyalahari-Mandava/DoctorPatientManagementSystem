package com.springboot.hospitalmanagement.entities.patient;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patientId")
    private Long patientId;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;


}
