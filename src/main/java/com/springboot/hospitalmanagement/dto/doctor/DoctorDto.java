package com.springboot.hospitalmanagement.dto.doctor;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDto {

   // private long doctorId;
    private String firstName;
    private String lastName;
    private String department;

}
