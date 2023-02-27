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
import java.util.List;

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
     * Finds a  Patient by its ID.
     *
     * @param id the ID of the patient to find
     * @return the  Patient  with the given ID
     * @throws EntityNotFoundException if the patient with the given ID is not found in the database
     */
    public Patient findPatientById(Long id) {
        return patientRepository.findPatientById(id).orElseThrow(() ->
                new EntityNotFoundException("Patient Not Found"));
    }

    /**
     * Returns a list of all consults associated with a given patient.
     *
     * @param patient the patient for whom to retrieve consults
     * @return a list of Consult objects associated with the given patient
     */
    public List<Consult> getConsultsByPatient(Patient patient) {
        return consultService.listAllConsultsByPatient(patient);
    }

    /**
     * Returns a list of all symptoms associated with a given patient.
     *
     * @param patient the patient for whom to retrieve symptoms
     * @return a list of Symptom objects associated with the given patient
     */
    public List<Symptom> getSymptomsByPatient(Patient patient) {
        return symptomService.listAllSymptomsByPatient(patient);
    }


}
