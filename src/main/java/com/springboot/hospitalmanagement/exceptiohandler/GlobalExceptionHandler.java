package com.springboot.hospitalmanagement.exceptiohandler;

import com.springboot.hospitalmanagement.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDoctorNotFound(DoctorNotFoundException doctorNotFoundException){
        ErrorResponse error = new ErrorResponse(
                doctorNotFoundException.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePatientNotFound(PatientNotFoundException patientNotFoundException){
        ErrorResponse error = new ErrorResponse(
                patientNotFoundException.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PatientDetailsInvalidException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPatientDetails(PatientDetailsInvalidException patientDetailsInvalid) {
        ErrorResponse error = new ErrorResponse(
                patientDetailsInvalid.getErrors(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DoctorDetailsInvalidException.class)
    public ResponseEntity<ErrorResponse> handleInvalidDoctorDetails(DoctorDetailsInvalidException doctorDetailsInvalidException){
        ErrorResponse error = new ErrorResponse(
                doctorDetailsInvalidException.getErrors(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDoctorIdException.class)
    public ResponseEntity<ErrorResponse> handleInvalidDoctorIdException(InvalidDoctorIdException invalidDoctorIdException){
        ErrorResponse error = new ErrorResponse(
                invalidDoctorIdException.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPatientIdException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPatientIdException(InvalidPatientIdException invalidPatientIdException){
        ErrorResponse error = new ErrorResponse(
                invalidPatientIdException.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFoundException(
            NoResourceFoundException ex) {

        String path = ex.getResourcePath();
        String customMessage;

        if (path.contains("doctor/delete")) {
            customMessage = "Doctor Id is missing in the request URL";
        } else {
            customMessage = "Requested URL not found: /" + path;
        }

        ErrorResponse error = new ErrorResponse(customMessage, LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(
            MethodArgumentTypeMismatchException ex) {

        String customMessage = "Doctor Id must be a valid number, received: " + ex.getValue();

        ErrorResponse error = new ErrorResponse(customMessage, LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

