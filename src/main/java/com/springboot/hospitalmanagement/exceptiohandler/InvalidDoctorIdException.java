package com.springboot.hospitalmanagement.exceptiohandler;

public class InvalidDoctorIdException extends RuntimeException{
    public InvalidDoctorIdException(String message){
        super(message);
    }
}
