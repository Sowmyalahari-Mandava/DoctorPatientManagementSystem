package com.springboot.hospitalmanagement.repository.doctor;

import com.springboot.hospitalmanagement.entities.doctor.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
}
