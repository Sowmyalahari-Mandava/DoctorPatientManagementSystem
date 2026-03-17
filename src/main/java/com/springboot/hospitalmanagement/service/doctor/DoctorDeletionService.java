package com.springboot.hospitalmanagement.service.doctor;

import com.springboot.hospitalmanagement.entities.doctor.DoctorEntity;
import com.springboot.hospitalmanagement.entities.patient.PatientEntity;
import com.springboot.hospitalmanagement.exceptiohandler.DoctorNotFoundException;
import com.springboot.hospitalmanagement.exceptiohandler.PatientNotFoundException;
import com.springboot.hospitalmanagement.repository.doctor.DoctorRepository;
import com.springboot.hospitalmanagement.response.doctor.DoctorResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorDeletionService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void deleteDoctorById(Long doctorId){

        DoctorEntity doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor is not found with id "+doctorId));
        doctorRepository.delete(doctor);
    }
}
