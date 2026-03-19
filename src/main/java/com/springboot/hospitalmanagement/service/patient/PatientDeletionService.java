package com.springboot.hospitalmanagement.service.patient;

import com.springboot.hospitalmanagement.entities.patient.PatientEntity;
import com.springboot.hospitalmanagement.exceptiohandler.PatientNotFoundException;
import com.springboot.hospitalmanagement.repository.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientDeletionService {

    private final PatientRepository patientRepository;

    public PatientDeletionService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void deletePatientById(Long patientId){

    PatientEntity patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new PatientNotFoundException("Patient is found with patientId "+patientId));

        patientRepository.deleteById(patientId);
    }
}
