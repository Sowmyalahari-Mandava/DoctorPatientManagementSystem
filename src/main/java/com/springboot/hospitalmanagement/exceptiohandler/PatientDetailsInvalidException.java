package com.springboot.hospitalmanagement.exceptiohandler;

import lombok.Getter;

import java.util.List;

@Getter
public class PatientDetailsInvalidException extends RuntimeException{
    private final List<String> errors;

    public PatientDetailsInvalidException(List<String> errors) {
        super("Patient validation failed");
        this.errors = errors;
    }

}
