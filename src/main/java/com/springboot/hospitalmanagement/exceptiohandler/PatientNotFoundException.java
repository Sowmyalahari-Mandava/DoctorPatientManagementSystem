package com.springboot.hospitalmanagement.exceptiohandler;

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(String message){
        super(message);
    }
}
