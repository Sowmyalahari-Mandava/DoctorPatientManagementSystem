package com.springboot.hospitalmanagement.controller.patient;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.dto.patient.PatientDto;
import com.springboot.hospitalmanagement.response.patient.PatientResponse;
import com.springboot.hospitalmanagement.service.patient.PatientCreationService;
import com.springboot.hospitalmanagement.validation.PatientValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Controller class to insert patient
 */
@RestController
@RequestMapping(ApiConstants.PATIENTS_API)
public class PatientCreationController {

    private final PatientValidation patientValidation;

    private final PatientCreationService patientCreationService;

    public PatientCreationController(PatientValidation patientValidation, PatientCreationService patientCreationService) {
        this.patientValidation = patientValidation;
        this.patientCreationService = patientCreationService;
    }

    /*
    Method to insert patient using POST mapping
     */
    @PostMapping(ApiConstants.INSERT_PATIENT)
    public PatientResponse createPatient(@RequestBody PatientDto patientDto){
        patientValidation.validatePatientDetails(patientDto);
        return patientCreationService.addPatient(patientDto);
    }

}
