package com.challenge.challenge.transports;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
public class DoctorDTO {
    private UUID uuid;
    private String name;
    private SpecialityDTO specialityDTO;
}