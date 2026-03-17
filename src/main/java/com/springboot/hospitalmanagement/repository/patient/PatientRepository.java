package com.springboot.hospitalmanagement.repository.patient;

import com.springboot.hospitalmanagement.entities.patient.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospitalmanagement.entities.patient.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

}

