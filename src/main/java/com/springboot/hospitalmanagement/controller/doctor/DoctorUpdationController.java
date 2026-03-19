package com.springboot.hospitalmanagement.controller.doctor;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.dto.doctor.DoctorDto;
import com.springboot.hospitalmanagement.response.doctor.DoctorResponse;
import com.springboot.hospitalmanagement.service.doctor.DoctorUpdationService;
import com.springboot.hospitalmanagement.validation.DoctorValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
Controller class for Updating doctor details
 */
@RestController
@RequestMapping(ApiConstants.DOCTORS_API)
public class DoctorUpdationController {

    private final DoctorUpdationService doctorUpdationService;

    private final DoctorValidation doctorValidation;

    public DoctorUpdationController(DoctorUpdationService doctorUpdationService, DoctorValidation doctorValidation) {
        this.doctorUpdationService = doctorUpdationService;
        this.doctorValidation = doctorValidation;
    }

    /*
    Method for updating doctor details using doctorId using PATCH mapping
     */
    @PatchMapping(ApiConstants.UPDATE_DOCTOR_DETAILS)
    public DoctorResponse modifyDoctorDetails(@PathVariable("doctorId") Long doctorId, @RequestBody DoctorDto doctorDetails){
        doctorValidation.validateDoctorId(doctorId);
        doctorValidation.validateDoctorDetails(doctorDetails);
         return doctorUpdationService.updateDoctorDetails(doctorId, doctorDetails);
    }
}
