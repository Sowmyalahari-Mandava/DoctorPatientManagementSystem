package com.springboot.hospitalmanagement.controller.patient;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.dto.doctor.DoctorDto;
import com.springboot.hospitalmanagement.dto.patient.PatientDto;
import com.springboot.hospitalmanagement.response.patient.PatientResponse;
import com.springboot.hospitalmanagement.service.patient.PatientUpdationService;
import com.springboot.hospitalmanagement.validation.PatientValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
Controller class for updating patient details
 */
@RestController
@RequestMapping(ApiConstants.PATIENTS_API)
public class patientUpdationController {

    private final PatientUpdationService patientUpdationService;

    private final PatientValidation patientValidation;

    public patientUpdationController(PatientUpdationService patientUpdationService, PatientValidation patientValidation) {
        this.patientUpdationService = patientUpdationService;
        this.patientValidation = patientValidation;
    }

    /*
    Method for updating patient details using PATCH mapping
     */
    @PatchMapping(ApiConstants.UPDATE_PATIENT_DETAILS)
    public PatientResponse modifyDoctorDetails(@PathVariable("patientId") Long patientId, @RequestBody PatientDto patientDetails){
        patientValidation.validatePatientId(patientId);
        patientValidation.validatePatientDetails(patientDetails);
        return patientUpdationService.updatePatientDetails(patientId, patientDetails);
    }
}
