package com.challenge.challenge.controllers;

import com.challenge.challenge.mappers.ConsultMapper;
import com.challenge.challenge.mappers.PatientMapper;
import com.challenge.challenge.mappers.SymptomMapper;
import com.challenge.challenge.models.Patient;
import com.challenge.challenge.services.PatientService;
import com.challenge.challenge.transports.ConsultDTO;
import com.challenge.challenge.transports.PatientDTO;
import com.challenge.challenge.transports.SymptomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired(required = false)
    private PatientMapper patientMapper;
    @Autowired
    private SymptomMapper symptomMapper;
    @Autowired
    private ConsultMapper consultMapper;

    /**
     * Retrieves a paginated list of all patients, filtered and sorted by either name or age.
     *
     * @param search   The search term to filter the patients by (defaults to "_").
     * @param pageable The paging and sorting parameters.
     * @return The paginated list of patients that match the search term and paging/sorting parameters, wrapped in a ResponseEntity with HTTP status code 200 (OK).
     */
    @GetMapping()
    public ResponseEntity<Page<PatientDTO>> findPageGestoresProcedimento(
            @RequestParam(value = "search", defaultValue = "_") String search,
            @PageableDefault(value = 5, page = 0, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.patientService
                        .getPageListOfPatients(search, pageable)
                        .map(patientMapper::toDTO));
    }

    /**
     GET endpoint to retrieve all consults with symptoms associated with a specific patient.
     @param patientId the ID of the patient to retrieve consults with symptoms for.
     @return a ResponseEntity containing a Map with two keys: "Consults" and "Symptoms".
     */
    @GetMapping("/{patientId}/consults")
    public ResponseEntity<Map<String, Object>> getConsultsWithSymptomsByPatient(@PathVariable("patientId") Long patientId) {
        Patient patient = patientService.findPatientById(patientId);

        List<ConsultDTO> consults =  patientService.getConsultsByPatient(patient).stream()
                .map(consult -> consultMapper.toDTO(consult))
                .collect(Collectors.toList());

        List<SymptomDTO> symptoms =  patientService.getSymptomsByPatient(patient).stream()
                .map(symptom -> symptomMapper.toDTO(symptom))
                .collect(Collectors.toList());


        Map<String, Object> result = new HashMap<>();
        result.put("Consults", consults);
        result.put("Symptoms", symptoms);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
