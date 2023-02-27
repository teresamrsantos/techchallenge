package com.challenge.challenge.services;

import com.challenge.challenge.models.Consult;
import com.challenge.challenge.models.Patient;
import com.challenge.challenge.models.Speciality;
import com.challenge.challenge.repositories.ConsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultService {

    @Autowired
    ConsultRepository consultRepository;

    public Long countUniquePacientsPerSpeciality(Speciality speciality) {
        return consultRepository.countDistinctPatientsBySpeciality(speciality.getId());
    }

    public List<Consult> listAllConsultsByPatient(Patient patient) {
        return consultRepository.findByPatient(patient);
    }
}
