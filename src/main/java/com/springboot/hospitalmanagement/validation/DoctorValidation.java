package com.springboot.hospitalmanagement.validation;

import com.springboot.hospitalmanagement.dto.doctor.DoctorDto;
import com.springboot.hospitalmanagement.exceptiohandler.DoctorDetailsInvalidException;
import com.springboot.hospitalmanagement.exceptiohandler.InvalidDoctorIdException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorValidation {

    public void validateDoctorId(Long doctorId){

        if(doctorId==null){
            throw new InvalidDoctorIdException("Doctor Id cannot be null");
        }
        else if(doctorId<=0){
            throw new InvalidDoctorIdException("Doctor Id cannot be less than zero");
        }
    }

    public void validateDoctorDetails(DoctorDto doctorDto){
        List<String> errors = new ArrayList<>();
        if(doctorDto.getFirstName()==null || doctorDto.getFirstName().isBlank()){
            errors.add("First name cannot be null or empty");
        }
        if(doctorDto.getLastName()==null || doctorDto.getLastName().isBlank()){
            errors.add("Last name cannot be null or empty");
        }
        if(doctorDto.getDepartment()==null || doctorDto.getDepartment().isBlank()){
            errors.add("Department cannot be null or blank");
        }
        if(!errors.isEmpty()){
            throw new DoctorDetailsInvalidException(errors);
        }
    }
}
