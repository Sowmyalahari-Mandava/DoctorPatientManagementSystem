package com.springboot.hospitalmanagement.controller.patient;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.enums.MessageKeyEnum;
import com.springboot.hospitalmanagement.service.patient.PatientDeletionService;
import com.springboot.hospitalmanagement.validation.PatientValidation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Controller class to delete patient
 */
@RestController
@RequestMapping(ApiConstants.PATIENTS_API)
public class PatientDeletionController {

    private final PatientValidation patientValidation;

    private final PatientDeletionService patientDeletionService;

    public PatientDeletionController(PatientValidation patientValidation, PatientDeletionService patientDeletionService) {
        this.patientValidation = patientValidation;
        this.patientDeletionService = patientDeletionService;
    }

    /*
    Method for deleting using id using DELETE mapping
     */
    @DeleteMapping(ApiConstants.DELETE_PATIENT_BY_ID)
    public MessageKeyEnum removePatientById(@PathVariable("patientId") Long patientId){
        patientValidation.validatePatientId(patientId);
        patientDeletionService.deletePatientById(patientId);
        return MessageKeyEnum.PATIENT_DELETED_SUCCESSFULLY;
    }
}
