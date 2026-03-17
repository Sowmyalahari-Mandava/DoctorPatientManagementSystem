package com.springboot.hospitalmanagement.service.patient;

import com.springboot.hospitalmanagement.entities.patient.PatientEntity;
import com.springboot.hospitalmanagement.exceptiohandler.PatientNotFoundException;
import com.springboot.hospitalmanagement.repository.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientDeletionService {

    @Autowired
    private PatientRepository patientRepository;

    public void deletePatientById(Long id){

    PatientEntity patient = patientRepository.findById(id)
            .orElseThrow(() -> new PatientNotFoundException("Patient is found with id "+id));

        patientRepository.deleteById(id);
    }
}
