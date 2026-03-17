package com.springboot.hospitalmanagement.enums;

import lombok.Getter;

@Getter
public enum MessageKeyEnum {

    DOCTOR_DELETED_SUCCESSFULLY("doctor.deleted.successfully"),
    PATIENT_DELETED_SUCCESSFULLY("patient.deleted.successfully");
    private final String key;

    MessageKeyEnum(String key) {
        this.key = key;
    }
}
