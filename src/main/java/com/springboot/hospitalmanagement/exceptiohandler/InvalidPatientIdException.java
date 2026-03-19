package com.springboot.hospitalmanagement.exceptiohandler;

public class InvalidPatientIdException extends RuntimeException{
    public InvalidPatientIdException(String message){
        super(message);
    }
}
