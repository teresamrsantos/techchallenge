package com.challenge.challenge.services;

import com.challenge.challenge.models.Consult;
import com.challenge.challenge.models.Pathology;
import com.challenge.challenge.models.Patient;
import com.challenge.challenge.models.Symptom;
import com.challenge.challenge.repositories.PatientRepository;
import com.challenge.challenge.specifications.PatientSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ConsultService consultService;
    @Autowired
    SymptomService symptomService;
    /**
     * Get All Patients filtered either by age or name and within a page according to the attributes sent on the pageable,
     * such as page number, number of items per page, sort direction and which attribute should it be sorted by.
     *
     * @param filter
     * @param pageable
     * @return
     */
    public Page<Patient> getPageListOfPatients(String filter, Pageable pageable) {
        Specification<Patient> filterSpec = PatientSpecification.filters(filter);
        return this.patientRepository.findAll(filterSpec, pageable);
    }


    public Patient findPatientByUuid(UUID uuidPatient) {
        return patientRepository.findByUuid(uuidPatient).orElseThrow(() ->
                new EntityNotFoundException("Patient Not Found"));
    }

    public List<Map<Consult, List<Symptom>>> getConsultsWithSymptomsByPatient(UUID patientUUID) {
        Patient patient = findPatientByUuid(patientUUID);
        List<Map<Consult, List<Symptom>>> result = new ArrayList<>();

        List<Consult> consults = consultService.listAllConsultsByPatient(patient);
        for (Consult consult : consults) {
            for (Pathology pathology : consult.getPatient().getPathologyList()) {
            List<Symptom> symptoms = pathology.getSymptomList();
            Map<Consult, List<Symptom>> consultSymptomsMap = new HashMap<>();
            consultSymptomsMap.put(consult, symptoms);
            result.add(consultSymptomsMap);
        }

        return result;
    }


}
