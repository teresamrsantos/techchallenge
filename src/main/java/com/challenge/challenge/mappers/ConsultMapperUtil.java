package com.challenge.challenge.mappers;

import com.challenge.challenge.models.Doctor;
import com.challenge.challenge.models.Patient;
import com.challenge.challenge.services.DoctorService;
import com.challenge.challenge.services.PatientService;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsultMapperUtil {
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;


    @Named("getDoctorById")
    public Doctor getDoctorById(Long id) {
        return doctorService.findDoctorById(id);
    }

    @Named("getPatientById")
    public Patient getPatientById(Long id) {
        return patientService.findPatientById(id);
    }
}
