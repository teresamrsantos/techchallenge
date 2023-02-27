package com.challenge.challenge.controllers;

import com.challenge.challenge.mappers.SpecialityMapper;
import com.challenge.challenge.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @Autowired(required = false)
    private SpecialityMapper specialityMapper;

    /**
     * Retrieves a list of top specialities based on the number of distinct patients assigned to each one.
     *
     * @return a  ResponseEntity with a list of Map<String, Object representing each speciality and its patient count.
     */
    /* curl --request GET \--url http://localhost:8080/challenge/speciality */
    @GetMapping()
    public ResponseEntity<List<Map<String, Object>>> getListOfTopSpecialities() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.specialityService
                        .getPatientCountPerSpeciality());
    }
}
