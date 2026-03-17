package com.springboot.hospitalmanagement.response.patient;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponse {
    private Long id;
    private String firstName;
    private String lastName;

}
