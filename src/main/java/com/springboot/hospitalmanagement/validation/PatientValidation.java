package com.springboot.hospitalmanagement.validation;

import com.springboot.hospitalmanagement.dto.patient.PatientDto;
import com.springboot.hospitalmanagement.enums.MessageKeyEnum;
import com.springboot.hospitalmanagement.exceptiohandler.InvalidPatientIdException;
import com.springboot.hospitalmanagement.exceptiohandler.PatientDetailsInvalidException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientValidation {

    public void validatePatientDetails(PatientDto patientDto){
        List<String> errors = new ArrayList<>();
        if(patientDto.getFirstName()==null || patientDto.getFirstName().isBlank() ){
            errors.add(MessageKeyEnum.PATIENT_FIRSTNAME_IS_NOT_NULL_OR_EMPTY.getKey());
        }
        if(patientDto.getLastName()==null ||patientDto.getLastName().isBlank()){
            errors.add(MessageKeyEnum.PATIENT_LASTNAME_IS_NOT_NULL_OR_EMPTY.getKey());
        }
        if (!errors.isEmpty()) {
            throw new PatientDetailsInvalidException(errors);
        }
    }

    public void validatePatientId(Long patientId){

        if(patientId==null){
            throw new InvalidPatientIdException(MessageKeyEnum.PATIENT_ID_IS_NOT_NULL.getKey());
        }
        else if(patientId<=0){
            throw new InvalidPatientIdException(MessageKeyEnum.PATIENT_ID_IS_GREATER_THAN_ZERO.getKey());
        }
    }
}
