package com.springboot.hospitalmanagement.controller.patient;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.enums.MessageKeyEnum;
import com.springboot.hospitalmanagement.service.patient.PatientDeletionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.PATIENTS_API)
public class PatientDeletionController {

    private final PatientDeletionService patientDeletionService;

    public PatientDeletionController(PatientDeletionService patientDeletionService) {
        this.patientDeletionService = patientDeletionService;
    }

    @DeleteMapping(ApiConstants.DELETE_PATIENT_BY_ID)
    public MessageKeyEnum removePatientById(@PathVariable("id") Long id){
        patientDeletionService.deletePatientById(id);
        return MessageKeyEnum.PATIENT_DELETED_SUCCESSFULLY;
    }
}
