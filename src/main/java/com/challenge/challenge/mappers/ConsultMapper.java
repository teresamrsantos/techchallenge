package com.challenge.challenge.mappers;

import com.challenge.challenge.models.Consult;
import com.challenge.challenge.transports.ConsultDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = ConsultMapperUtil.class)
public interface ConsultMapper {

    @Mapping(target = "doctorId", source = "doctor.id")
    @Mapping(target = "doctorName", source = "doctor.name")
    @Mapping(target = "patientId", source = "patient.id")
    @Mapping(target = "patientName", source = "patient.name")
    ConsultDTO toDTO(Consult consult);

    @Mapping(target = "doctor", source = "doctorId", qualifiedByName = "getDoctorById")
    @Mapping(target = "patient", source = "patientId", qualifiedByName = "getPatientById")
    Consult toEntity(ConsultDTO consultDto);
}
