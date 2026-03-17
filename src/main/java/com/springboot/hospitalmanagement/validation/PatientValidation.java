package com.springboot.hospitalmanagement.validation;

import com.springboot.hospitalmanagement.dto.patient.PatientDto;
import com.springboot.hospitalmanagement.exceptiohandler.PatientDetailsInvalidException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientValidation {

    public void validatePatientDetails(PatientDto patientDto){
        List<String> errors = new ArrayList<>();
        if(patientDto.getFirstName()==null || patientDto.getFirstName().isBlank() ){
            errors.add("FirstName cannot be empty or null");
        }
        if(patientDto.getLastName()==null ||patientDto.getLastName().isBlank()){
            errors.add("LastName cannot be empty or null");
        }
        if (!errors.isEmpty()) {
            throw new PatientDetailsInvalidException(errors);
        }

    }
}
