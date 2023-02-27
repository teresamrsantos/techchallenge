package com.challenge.challenge.mappers;

import com.challenge.challenge.models.Speciality;
import com.challenge.challenge.transports.SpecialityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface SpecialityMapper {

    SpecialityDTO toDTO(Speciality speciality);

    Speciality toEntity(SpecialityDTO specialityDTO);
}
