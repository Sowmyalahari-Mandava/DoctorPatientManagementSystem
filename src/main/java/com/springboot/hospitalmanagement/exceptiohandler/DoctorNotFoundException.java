package com.springboot.hospitalmanagement.exceptiohandler;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message){

        super(message);
    }
}
