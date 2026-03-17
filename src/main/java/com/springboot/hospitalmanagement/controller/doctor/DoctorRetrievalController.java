package com.springboot.hospitalmanagement.controller.doctor;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.response.doctor.DoctorResponse;
import com.springboot.hospitalmanagement.service.doctor.DoctorRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.DOCTORS_API)
public class DoctorRetrievalController {

    @Autowired
    private DoctorRetrievalService doctorRetrievalService;

    @GetMapping(ApiConstants.GET_ALL_DOCTORS)
    public List<DoctorResponse> findAllDoctors(){

        return doctorRetrievalService.getAllDoctors();
    }

    @GetMapping(ApiConstants.GET_DOCTOR_BY_ID)
    public DoctorResponse findDoctorById(@PathVariable("doctorId") Long doctorId){

        DoctorResponse response = doctorRetrievalService.getDoctorById(doctorId);
        return response;

    }

}
