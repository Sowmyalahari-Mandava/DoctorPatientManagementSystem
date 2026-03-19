package com.springboot.hospitalmanagement.service.patient;

import com.springboot.hospitalmanagement.dto.patient.PatientDto;
import com.springboot.hospitalmanagement.entities.patient.PatientEntity;
import com.springboot.hospitalmanagement.exceptiohandler.PatientNotFoundException;
import com.springboot.hospitalmanagement.repository.patient.PatientRepository;
import com.springboot.hospitalmanagement.response.patient.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientUpdationService {

    private final PatientRepository patientRepository;

    public PatientUpdationService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponse updatePatientDetails(Long id, PatientDto patientDetails){
        PatientEntity patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient is found with id "+id));

            if(patientDetails.getFirstName() != null) {
                patient.setFirstName(patientDetails.getFirstName());
            }

            if(patientDetails.getLastName() != null){
                patient.setLastName(patientDetails.getLastName());
            }
            patient = patientRepository.save(patient);

        PatientResponse response = PatientResponse.builder()
                .patientId(patient.getPatientId())
                    .firstName(patient.getFirstName())
                    .lastName(patient.getLastName())
                    .build();

        return response;
    }
}
