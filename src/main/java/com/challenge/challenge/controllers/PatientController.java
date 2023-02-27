package com.challenge.challenge.controllers;

import com.challenge.challenge.mappers.ConsultMapper;
import com.challenge.challenge.mappers.PatientMapper;
import com.challenge.challenge.mappers.SymptomMapper;
import com.challenge.challenge.models.Consult;
import com.challenge.challenge.models.Patient;
import com.challenge.challenge.models.Symptom;
import com.challenge.challenge.services.PatientService;
import com.challenge.challenge.transports.ConsultDTO;
import com.challenge.challenge.transports.PatientDTO;
import com.challenge.challenge.transports.SymptomDTO;
import com.challenge.challenge.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import java.util.UUID;
import java.util.stream.Collectors;


@Api(tags = {"Patient"})
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

    @ApiOperation(value = "Get list of all patients with pagination, filtering and sorting",
            notes = "This endpoint will return the data for all the patients with pagination, filtering and sorting by either age or name")
    @GetMapping()
    public ResponseEntity<Page<PatientDTO>> findPageGestoresProcedimento(
            @RequestParam(value = Constants.FIELD_SEARCH, defaultValue = "_") String search,
            @PageableDefault(value = 5, page = 0, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.patientService
                        .getPageListOfPatients(search, pageable)
                        .map(patientMapper::toDTO));
    }


    @GetMapping("/{patientUuid}/consults")
    public ResponseEntity<List<Map<ConsultDTO, List<SymptomDTO>>>> getConsultsWithSymptomsByPatient(@PathVariable("patientUuid") UUID patientUuid) {
        List<Map<Consult, List<Symptom>>> consultsList = patientService.getConsultsWithSymptomsByPatient(patientUuid);

        List<Map<ConsultDTO, List<SymptomDTO>>> consultsDTOList = consultsList.stream()
                .map(consultSymptomMap -> {
                    ConsultDTO consultDTO = consultMapper.toDTO(consultSymptomMap.keySet().iterator().next());
                    List<SymptomDTO> symptomsDTO = symptomMapper.toDTO();
                    Map<ConsultDTO, List<SymptomDTO>> consultSymptomDTOMap = new HashMap<>();
                    consultSymptomDTOMap.put(consultDTO, symptomsDTO);
                    return consultSymptomDTOMap;
                })
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(consultsDTOList);
    }

}
}
