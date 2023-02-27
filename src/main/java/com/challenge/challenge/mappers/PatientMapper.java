package com.challenge.challenge.mappers;

import com.challenge.challenge.models.Patient;
import com.challenge.challenge.transports.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring", uses = ConsultMapperUtil.class)
public interface PatientMapper {

    PatientDTO toDTO(Patient patient);

    Patient toEntity(PatientDTO patientDTO);
}
