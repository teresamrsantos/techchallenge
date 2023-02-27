package com.challenge.challenge.services;

import com.challenge.challenge.models.Patient;
import com.challenge.challenge.models.Symptom;
import com.challenge.challenge.repositories.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService {

    @Autowired
    SymptomRepository symptomRepository;


    public List<Symptom> listAllSymptomsByPatient(Patient patient) {
        return symptomRepository.findAllSymptomsByPatientId(patient.getId());
    }
}
