package com.springboot.hospitalmanagement.service.doctor;

import com.springboot.hospitalmanagement.entities.doctor.DoctorEntity;
import com.springboot.hospitalmanagement.exceptiohandler.DoctorNotFoundException;
import com.springboot.hospitalmanagement.repository.doctor.DoctorRepository;
import com.springboot.hospitalmanagement.response.doctor.DoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorRetrievalService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorResponse> getAllDoctors(){
         List<DoctorEntity> doctors = doctorRepository.findAll();

         List<DoctorResponse> responseList = new ArrayList<>();

         for(DoctorEntity doctor : doctors){

             DoctorResponse response = new DoctorResponse();
             response.setDoctorId(doctor.getDoctorId());
             response.setFirstName(doctor.getFirstName());
             response.setLastName(doctor.getLastName());
             response.setDepartment(doctor.getDepartment());

             responseList.add(response);
         }
         return responseList;
    }
    public DoctorResponse getDoctorById(Long id){

        DoctorEntity doctor = doctorRepository.findById(id).orElseThrow(()-> new DoctorNotFoundException("Doctor not found with id "+id));

        DoctorResponse response = null;

            response = DoctorResponse.builder()
                    .doctorId(doctor.getDoctorId())
                    .firstName(doctor.getFirstName())
                    .lastName(doctor.getLastName())
                    .department(doctor.getDepartment())
                    .build();

        return response;
    }
}
