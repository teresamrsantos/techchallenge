package com.challenge.challenge.mappers;

import com.challenge.challenge.models.Consult;
import com.challenge.challenge.transports.ConsultDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface ConsultMapper {

    ConsultDTO toDTO(Consult consult);

    Consult toEntity(ConsultDTO consultDto);
}
