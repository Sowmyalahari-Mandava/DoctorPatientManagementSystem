package com.springboot.hospitalmanagement.controller.patient;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.dto.patient.PatientDto;
import com.springboot.hospitalmanagement.response.patient.PatientResponse;
import com.springboot.hospitalmanagement.service.patient.PatientRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.PATIENTS_API)
public class PatientRetrievalController {

    @Autowired
    private PatientRetrievalService patientRetrievalService;

    @GetMapping(ApiConstants.GET_ALL_PATIENTS)
    public List<PatientResponse> findAllPatients(){
        return patientRetrievalService.getAllPatients();
    }

    @GetMapping(ApiConstants.GET_PATIENT_BY_ID)
    public PatientResponse findPatientById(@PathVariable("id") Long id){
        return patientRetrievalService.getPatientById(id);
    }
}
