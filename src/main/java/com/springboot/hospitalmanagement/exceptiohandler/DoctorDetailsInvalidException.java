package com.springboot.hospitalmanagement.exceptiohandler;

import lombok.Getter;

import java.util.List;

@Getter
public class DoctorDetailsInvalidException extends RuntimeException{

    private final List<String> errors;

    public DoctorDetailsInvalidException(List<String> errors) {
        super();
        this.errors = errors;
    }
}
