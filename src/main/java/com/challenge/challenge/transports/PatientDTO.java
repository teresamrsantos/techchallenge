package com.challenge.challenge.transports;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class PatientDTO {
    private UUID uuid;
    private String name;
    private String age;
    private List<PathologyDTO> pathologyList;
}
