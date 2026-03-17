package com.springboot.hospitalmanagement.service.patient;

import com.springboot.hospitalmanagement.dto.patient.PatientDto;
import com.springboot.hospitalmanagement.entities.patient.PatientEntity;
import com.springboot.hospitalmanagement.repository.patient.PatientRepository;
import com.springboot.hospitalmanagement.response.patient.PatientResponse;
import org.springframework.stereotype.Service;

@Service
public class PatientCreationService {

    private final PatientRepository patientRepository;

    public PatientCreationService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponse addPatient(PatientDto patientDto) {

        PatientEntity patient = PatientEntity.builder()
                .id(patientDto.getId())
                .firstName(patientDto.getFirstName())
                .lastName(patientDto.getLastName())
                .build();

        patient = patientRepository.save(patient);

        PatientResponse response = PatientResponse.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .build();

        return response;

    }
}
