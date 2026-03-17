package com.springboot.hospitalmanagement.dto.patient;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDto {
    private Long id;
    private String firstName;
    private String lastName;

}
