package com.challenge.challenge.services;

import com.challenge.challenge.models.Doctor;
import com.challenge.challenge.models.Patient;
import com.challenge.challenge.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;


    public Doctor findDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Doctor Not Found"));
    }

}
