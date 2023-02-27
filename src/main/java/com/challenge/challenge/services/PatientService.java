package com.challenge.challenge.services;

import com.challenge.challenge.models.Consult;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ConsultService consultService;
    @Autowired
    SymptomService symptomService;

    /**
     * Retrieves a page of patients based on the filtering parameters and pageable attributes.
     *
     * @param filter   String to filter patients by name or age
     * @param pageable pageable attributes such as page number, number of items per page, sort direction and which attribute should it be sorted by
     * @return a page of patients
     */
    public Page<Patient> getPageListOfPatients(String filter, Pageable pageable) {
        Specification<Patient> filterSpec = PatientSpecification.filters(filter);
        return this.patientRepository.findAll(filterSpec, pageable);
    }

    /**
     * Retrieves a patient by UUID
     *
     * @param uuidPatient the UUID of the patient to be retrieved
     * @return the patient with the given UUID
     * @throws EntityNotFoundException if no patient is found with the given UUID
     */
    public Patient findPatientById(Long uuidPatient) {
        return patientRepository.findPatientById(uuidPatient).orElseThrow(() ->
                new EntityNotFoundException("Patient Not Found"));
    }

    /**
     * Retrieves a map with two lists: Consults and Symptoms, both related to a specific patient.
     *
     * @param patientUUID the UUID of the patient whose consults and symptoms will be retrieved
     * @return a map with two lists: Consults and Symptoms
     * @throws EntityNotFoundException if no patient is found with the given UUID
     */
    public List<Consult> getConsultsByPatient(Patient patient) {
        return consultService.listAllConsultsByPatient(patient);
    }


    public  List<Symptom> getSymptomsByPatient(Patient patient) {
        return symptomService.listAllSymptomsByPatient(patient);
    }


}
