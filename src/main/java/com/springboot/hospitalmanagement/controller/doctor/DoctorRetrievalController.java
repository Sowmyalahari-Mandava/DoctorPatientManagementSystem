package com.springboot.hospitalmanagement.controller.doctor;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.response.doctor.DoctorResponse;
import com.springboot.hospitalmanagement.service.doctor.DoctorRetrievalService;
import com.springboot.hospitalmanagement.validation.DoctorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
Controller class for retrieving doctors
 */
@RestController
@RequestMapping(ApiConstants.DOCTORS_API)
public class DoctorRetrievalController {

    private final DoctorRetrievalService doctorRetrievalService;

    private final DoctorValidation doctorValidation;

    public DoctorRetrievalController(DoctorRetrievalService doctorRetrievalService, DoctorValidation doctorValidation) {
        this.doctorRetrievalService = doctorRetrievalService;
        this.doctorValidation = doctorValidation;
    }

    /*
    Method for retrieving all doctors using GET mapping
     */
    @GetMapping(ApiConstants.GET_ALL_DOCTORS)
    public List<DoctorResponse> findAllDoctors(){
        return doctorRetrievalService.getAllDoctors();
    }

    /*
    Method for retrieving single doctor using doctorId using GET mapping
     */
    @GetMapping(ApiConstants.GET_DOCTOR_BY_ID)
    public DoctorResponse findDoctorById(@PathVariable("doctorId") Long doctorId){
        doctorValidation.validateDoctorId(doctorId);
        return doctorRetrievalService.getDoctorById(doctorId);

    }

}
