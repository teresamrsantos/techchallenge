package com.challenge.challenge.mappers;

import com.challenge.challenge.models.Doctor;
import com.challenge.challenge.models.Patient;
import com.challenge.challenge.models.Speciality;
import com.challenge.challenge.services.DoctorService;
import com.challenge.challenge.services.PatientService;
import com.challenge.challenge.services.SpecialityService;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultMapperUtil {
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;
    @Autowired
    SpecialityService specialityService;

    /**
     Returns a Doctor instance with the given id.
     @param id The id of the doctor to retrieve.
     @return The Doctor instance.
     */
    @Named("getDoctorById")
    public Doctor getDoctorById(Long id) {
        return doctorService.findDoctorById(id);
    }

    /**
     Returns a Patient instance with the given id.
     @param id The id of the patient to retrieve.
     @return The Patient instance.
     */
    @Named("getPatientById")
    public Patient getPatientById(Long id) {
        return patientService.findPatientById(id);
    }

    /**
     Returns a Speciality instance with the given id.
     @param id The id of the speciality to retrieve.
     @return The Speciality instance.
     */
    @Named("getSpecialityById")
    public Speciality getSpecialityById(Long id) {
        return specialityService.findById(id);
    }
}