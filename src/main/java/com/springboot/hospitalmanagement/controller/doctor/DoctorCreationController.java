package com.springboot.hospitalmanagement.controller.doctor;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.dto.doctor.DoctorDto;
import com.springboot.hospitalmanagement.response.doctor.DoctorResponse;
import com.springboot.hospitalmanagement.service.doctor.DoctorCreationService;
import com.springboot.hospitalmanagement.validation.DoctorValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.DOCTORS_API)
public class DoctorCreationController {

    private final DoctorValidation doctorValidation;

    private final DoctorCreationService doctorCreationService;

    public DoctorCreationController(DoctorValidation doctorValidation, DoctorCreationService doctorCreationService) {
        this.doctorValidation = doctorValidation;
        this.doctorCreationService = doctorCreationService;
    }

    @PostMapping(ApiConstants.INSERT_DOCTOR)
    public  DoctorResponse createDoctor(@RequestBody DoctorDto doctorDetails) {
        doctorValidation.validateDoctorDetails(doctorDetails);
        return doctorCreationService.addDoctor(doctorDetails);
    }
}
