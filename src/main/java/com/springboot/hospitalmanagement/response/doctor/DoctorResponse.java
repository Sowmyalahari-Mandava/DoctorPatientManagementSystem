package com.springboot.hospitalmanagement.response.doctor;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponse {

    private long doctorId;
    private String firstName;
    private String lastName;
    private String department;

}
