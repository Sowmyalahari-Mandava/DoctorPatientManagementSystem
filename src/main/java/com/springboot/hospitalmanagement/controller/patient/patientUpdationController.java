package com.springboot.hospitalmanagement.controller.patient;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.dto.doctor.DoctorDto;
import com.springboot.hospitalmanagement.dto.patient.PatientDto;
import com.springboot.hospitalmanagement.response.patient.PatientResponse;
import com.springboot.hospitalmanagement.service.patient.PatientUpdationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.PATIENTS_API)
public class patientUpdationController {

    @Autowired
    private PatientUpdationService patientUpdationService;

    @PatchMapping(ApiConstants.UPDATE_PATIENT_DETAILS)
    public PatientResponse modifyDoctorDetails(@PathVariable("id") Long id, @RequestBody @Valid PatientDto patientDetails){
        return patientUpdationService.updatePatientDetails(id, patientDetails);
    }
}
