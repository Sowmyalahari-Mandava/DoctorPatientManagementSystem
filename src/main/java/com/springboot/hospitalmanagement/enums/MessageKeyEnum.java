package com.springboot.hospitalmanagement.enums;

import lombok.Getter;

@Getter
public enum MessageKeyEnum {

    DOCTOR_DELETED_SUCCESSFULLY("doctor.deleted.successfully"),
    PATIENT_DELETED_SUCCESSFULLY("patient.deleted.successfully"),
    DOCTOR_ID_IS_NOT_NULL("Doctor Id cannot be null"),
    DOCTOR_ID_IS_GREATER_THAN_ZERO("Doctor Id cannot be less than zero"),
    DOCTOR_FIRSTNAME_IS_NOT_NULL_OR_EMPTY("First name cannot be null or empty"),
    DOCTOR_LASTNAME_IS_NOT_NULL_OR_EMPTY("Last name cannot be null or empty"),
    DOCTOR_DEPARTMENT_IS_NOT_NULL_OR_BLANK("Department cannot be null or blank"),
    PATIENT_FIRSTNAME_IS_NOT_NULL_OR_EMPTY("FirstName cannot be empty or null"),
    PATIENT_LASTNAME_IS_NOT_NULL_OR_EMPTY("LastName cannot be empty or null"),
    PATIENT_ID_IS_NOT_NULL("Patient Id cannot be null"),
    PATIENT_ID_IS_GREATER_THAN_ZERO("Patient Id cannot be less than zero");

    private final String key;

    MessageKeyEnum(String key) {
        this.key = key;
    }
}
