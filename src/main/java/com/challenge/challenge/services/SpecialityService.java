package com.challenge.challenge.services;

import com.challenge.challenge.models.Speciality;
import com.challenge.challenge.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * Get All specialities that have more than 2 UNIQUE patients.
     *
     * @return
     */
    public List<Map<String, Object>> getPatientCountPerSpeciality() {
        List<Speciality> specialities = specialityRepository.findSpecialitiesWithMoreThanTwoUniquePatients();
        List<Map<String, Object>> results = new ArrayList<>();

        for (Speciality speciality : specialities) {
            Map<String, Object> result = new HashMap<>();
            Long patientCount = consultService.countUniquePacientsPerSpeciality(speciality);
            result.put("speciality", speciality.getDescription());
            result.put("patientCount", patientCount);
            results.add(result);
        }

        return results;
    }

}


