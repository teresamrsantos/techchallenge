package com.challenge.challenge.transports;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ConsultDTO {
    private UUID uuid;
    private UUID doctorUuid;
    private UUID patientUuid;
    private SpecialityDTO speciality;
}
