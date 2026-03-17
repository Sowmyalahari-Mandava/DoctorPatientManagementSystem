package com.springboot.hospitalmanagement.service.doctor;

import com.springboot.hospitalmanagement.dto.doctor.DoctorDto;
import com.springboot.hospitalmanagement.entities.doctor.DoctorEntity;
import com.springboot.hospitalmanagement.repository.doctor.DoctorRepository;
import com.springboot.hospitalmanagement.response.doctor.DoctorResponse;
import org.springframework.stereotype.Service;

@Service
public class DoctorCreationService {

    private final DoctorRepository doctorRepository;

    public DoctorCreationService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorResponse addDoctor(DoctorDto doctorDetails){


        DoctorEntity doctor = new DoctorEntity();

        doctor.setFirstName(doctorDetails.getFirstName());
        doctor.setLastName(doctorDetails.getLastName());
        doctor.setDepartment(doctorDetails.getDepartment());

        doctor = doctorRepository.save(doctor);

        DoctorResponse response = new DoctorResponse();

        response.setDoctorId(doctor.getDoctorId());
        response.setFirstName(doctor.getFirstName());
        response.setLastName(doctor.getLastName());
        response.setDepartment(doctor.getDepartment());

        return response;
    }

}
