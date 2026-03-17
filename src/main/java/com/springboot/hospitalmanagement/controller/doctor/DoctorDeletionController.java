package com.springboot.hospitalmanagement.controller.doctor;

import com.springboot.hospitalmanagement.constants.ApiConstants;
import com.springboot.hospitalmanagement.enums.MessageKeyEnum;
import com.springboot.hospitalmanagement.exceptiohandler.InvalidDoctorIdException;
import com.springboot.hospitalmanagement.service.doctor.DoctorDeletionService;
import com.springboot.hospitalmanagement.validation.DoctorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.DOCTORS_API)
public class DoctorDeletionController {

    private final DoctorValidation doctorValidation;

    private final DoctorDeletionService doctorDeletionService;

    public DoctorDeletionController(DoctorValidation doctorValidation, DoctorDeletionService doctorDeletionService) {
        this.doctorValidation = doctorValidation;
        this.doctorDeletionService = doctorDeletionService;
    }

    @DeleteMapping(ApiConstants.DELETE_DOCTOR_BY_ID)
    public String removeDoctor(@PathVariable("doctorId") Long doctorId){
        doctorValidation.validateDoctorId(doctorId);
        doctorDeletionService.deleteDoctorById(doctorId);
        return MessageKeyEnum.DOCTOR_DELETED_SUCCESSFULLY.getKey();
    }

}
