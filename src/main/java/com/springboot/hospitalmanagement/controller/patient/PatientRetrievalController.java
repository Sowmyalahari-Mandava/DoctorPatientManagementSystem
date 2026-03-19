package com.springboot.hospitalmanagement.controller.patient;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.dto.patient.PatientDto;
import com.springboot.hospitalmanagement.response.patient.PatientResponse;
import com.springboot.hospitalmanagement.service.patient.PatientRetrievalService;
import com.springboot.hospitalmanagement.validation.PatientValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
Controller class to retrieving patients
 */
@RestController
@RequestMapping(ApiConstants.PATIENTS_API)
public class PatientRetrievalController {

    private final PatientRetrievalService patientRetrievalService;

    private final PatientValidation patientValidation;

    public PatientRetrievalController(PatientRetrievalService patientRetrievalService, PatientValidation patientValidation) {
        this.patientRetrievalService = patientRetrievalService;
        this.patientValidation = patientValidation;
    }

    /*
    Method to retrieve all patients using GET mapping
     */
    @GetMapping(ApiConstants.GET_ALL_PATIENTS)
    public List<PatientResponse> findAllPatients(){
        return patientRetrievalService.getAllPatients();
    }

    /*
    Method to retrieve single patient using id using GET mapping
     */
    @GetMapping(ApiConstants.GET_PATIENT_BY_ID)
    public PatientResponse findPatientById(@PathVariable("patientId") Long patientId){
        patientValidation.validatePatientId(patientId);
        return patientRetrievalService.getPatientById(patientId);
    }
}
