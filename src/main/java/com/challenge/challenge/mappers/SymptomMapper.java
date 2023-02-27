package com.challenge.challenge.mappers;

import com.challenge.challenge.models.Symptom;
import com.challenge.challenge.transports.SymptomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface SymptomMapper {

    SymptomDTO toDTO(Symptom symptom);

    Symptom toEntity(SymptomDTO symptomDto);
}
