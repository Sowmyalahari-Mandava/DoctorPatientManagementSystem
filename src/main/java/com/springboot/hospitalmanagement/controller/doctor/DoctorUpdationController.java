package com.springboot.hospitalmanagement.controller.doctor;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.dto.doctor.DoctorDto;
import com.springboot.hospitalmanagement.response.doctor.DoctorResponse;
import com.springboot.hospitalmanagement.service.doctor.DoctorUpdationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.DOCTORS_API)
public class DoctorUpdationController {

    @Autowired
    private DoctorUpdationService doctorUpdationService;

    @PatchMapping(ApiConstants.UPDATE_DOCTOR_DETAILS)
    public DoctorResponse modifyDoctorDetails(@PathVariable("doctorId") Long doctorId, @RequestBody @Valid DoctorDto doctorDetails){
         return doctorUpdationService.updateDoctorDetails(doctorId, doctorDetails);
    }
}
