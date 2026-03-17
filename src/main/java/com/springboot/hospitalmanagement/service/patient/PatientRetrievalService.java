package com.springboot.hospitalmanagement.service.patient;

import com.springboot.hospitalmanagement.entities.patient.PatientEntity;
import com.springboot.hospitalmanagement.exceptiohandler.PatientNotFoundException;
import com.springboot.hospitalmanagement.repository.patient.PatientRepository;
import com.springboot.hospitalmanagement.response.patient.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientRetrievalService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientResponse> getAllPatients(){

        List<PatientEntity> patients = patientRepository.findAll();

        List<PatientResponse> responseList = new ArrayList<>();

        for(PatientEntity patient : patients) {
            PatientResponse response = PatientResponse.builder()
                    .id(patient.getId())
                    .firstName(patient.getFirstName())
                    .lastName(patient.getLastName())
                    .build();
            responseList.add(response);
        }
        return responseList;
    }

    public PatientResponse getPatientById(Long id){

        PatientEntity patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient is found with id "+id));

        PatientResponse response = null;

            response = PatientResponse.builder()
                    .id(patient.getId())
                    .firstName(patient.getFirstName())
                    .lastName(patient.getLastName())
                    .build();

        return response;

    }
}
