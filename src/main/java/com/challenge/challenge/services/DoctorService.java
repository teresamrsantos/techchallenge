package com.challenge.challenge.services;

import com.challenge.challenge.models.Doctor;
import com.challenge.challenge.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    /**
     * Finds a Doctor by ID.
     *
     * @param id the ID of the Doctor to be found.
     * @return the Doctor with the given ID.
     * @throws EntityNotFoundException if no Doctor with the given ID is found.
     */
    public Doctor findDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Doctor Not Found"));
    }

}
