package com.challenge.challenge.services;

import com.challenge.challenge.models.Speciality;
import com.challenge.challenge.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpecialityService {
    @Autowired
    SpecialityRepository specialityRepository;

    @Autowired
    ConsultService consultService;

    /**
     * Returns a list of maps containing the number of unique patients per speciality with more than two unique patients.
     *
     * @return a list of maps with the speciality description and the number of unique patients
     */
    public List<Map<String, Object>> getPatientCountPerSpeciality() {
        List<Speciality> specialities = specialityRepository.findSpecialitiesWithMoreThanTwoUniquePatients();
        List<Map<String, Object>> results = new ArrayList<>();

        for (Speciality speciality : specialities) {
            Map<String, Object> result = new HashMap<>();
            Long patientCount = consultService.countUniquePatientsPerSpeciality(speciality);
            result.put("speciality", speciality.getDescription());
            result.put("patientCount", patientCount);
            results.add(result);
        }

        return results;
    }

    /**
     * Finds a speciality by its ID.
     *
     * @param id the ID of the speciality to find
     * @return the speciality with the given ID
     * @throws EntityNotFoundException if the speciality with the given ID is not found
     */
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Speciality Not Found"));
    }
}


