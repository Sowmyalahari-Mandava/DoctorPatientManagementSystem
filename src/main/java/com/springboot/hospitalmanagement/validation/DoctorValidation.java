package com.springboot.hospitalmanagement.validation;

import com.springboot.hospitalmanagement.dto.doctor.DoctorDto;
import com.springboot.hospitalmanagement.enums.MessageKeyEnum;
import com.springboot.hospitalmanagement.exceptiohandler.DoctorDetailsInvalidException;
import com.springboot.hospitalmanagement.exceptiohandler.InvalidDoctorIdException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorValidation {

    public void validateDoctorId(Long doctorId){

        if(doctorId==null){
            throw new InvalidDoctorIdException(MessageKeyEnum.DOCTOR_ID_IS_NOT_NULL.getKey());
        }
        else if(doctorId<=0){
            throw new InvalidDoctorIdException(MessageKeyEnum.DOCTOR_ID_IS_GREATER_THAN_ZERO.getKey());
        }
    }

    public void validateDoctorDetails(DoctorDto doctorDto){
        List<String> errors = new ArrayList<>();
        if(doctorDto.getFirstName()==null || doctorDto.getFirstName().isBlank()){
            errors.add(MessageKeyEnum.DOCTOR_FIRSTNAME_IS_NOT_NULL_OR_EMPTY.getKey());
        }
        if(doctorDto.getLastName()==null || doctorDto.getLastName().isBlank()){
            errors.add(MessageKeyEnum.DOCTOR_LASTNAME_IS_NOT_NULL_OR_EMPTY.getKey());
        }
        if(doctorDto.getDepartment()==null || doctorDto.getDepartment().isBlank()){
            errors.add(MessageKeyEnum.DOCTOR_DEPARTMENT_IS_NOT_NULL_OR_BLANK.getKey());
        }
        if(!errors.isEmpty()){
            throw new DoctorDetailsInvalidException(errors);
        }
    }
}
