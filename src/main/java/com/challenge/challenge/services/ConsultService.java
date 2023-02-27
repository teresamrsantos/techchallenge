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

    /**
     * Counts the number of unique patients who have had consultations with a specific speciality.
     *
     * @param speciality the speciality for which to count unique patients
     * @return the number of unique patients who have had consultations with the given speciality
     */
    public Long countUniquePatientsPerSpeciality(Speciality speciality) {
        return this.consultRepository.countDistinctPatientsBySpeciality(speciality.getId());
    }

    /**
     * Returns a list of all consultations made by a specific patient.
     *
     * @param patient the patient for which to retrieve consultations
     * @return a list of all consultations made by the given patient
     */
    public List<Consult> listAllConsultsByPatient(Patient patient) {
        return this.consultRepository.findAllByPatient(patient);
    }


    /**
     * Creates a new medical consultation.
     *
     * @param newConsult the new consultation to create
     * @return the newly created consultation
     */
    public Consult createConsult(Consult newConsult) {
        Consult consultToSave = new Consult();
        consultToSave.setDoctor(newConsult.getDoctor());
        consultToSave.setPatient(newConsult.getPatient());
        consultToSave.setSpeciality(newConsult.getSpeciality());

        return this.consultRepository.save(consultToSave);
    }
}