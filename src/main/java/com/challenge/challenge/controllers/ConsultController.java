package com.challenge.challenge.controllers;

import com.challenge.challenge.mappers.ConsultMapper;
import com.challenge.challenge.models.Consult;
import com.challenge.challenge.services.ConsultService;
import com.challenge.challenge.transports.ConsultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consult")
public class ConsultController {

    @Autowired
    ConsultService consultService;
    @Autowired
    ConsultMapper consultMapper;

    /**
     * Creates a new consult based on the given ConsultDTO and returns the ID of the created consult in the response body.
     *
     * @param consultDTO the ConsultDTO containing the details of the new consult
     * @return a ResponseEntity containing the HTTP status code and the ID of the created consult
     */
    /* curl --location --request POST 'http://localhost:8080/consults' \
--header 'Content-Type: application/json' \
--data-raw '{
    "doctorId": 123,
    "patientId": 456,
    "specialityId": 789
}'*/
    @PostMapping()
    public ResponseEntity<Long> createConsult(@RequestBody ConsultDTO consultDTO) {
        Consult newConsult = consultMapper.toEntity(consultDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultService.createConsult(newConsult).getId());
    }
}