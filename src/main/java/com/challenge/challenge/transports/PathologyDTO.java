package com.challenge.challenge.transports;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class PathologyDTO {
    private UUID uuid;
    private List<SymptomDTO> symptomList;
}
