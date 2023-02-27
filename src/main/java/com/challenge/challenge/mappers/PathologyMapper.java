package com.challenge.challenge.mappers;

import com.challenge.challenge.models.Consult;
import com.challenge.challenge.models.Pathology;
import com.challenge.challenge.transports.ConsultDTO;
import com.challenge.challenge.transports.PathologyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface PathologyMapper {
    Pathology toEntity(PathologyDTO pathologyDTO);

    PathologyDTO toDTO(Pathology pathology);
}
