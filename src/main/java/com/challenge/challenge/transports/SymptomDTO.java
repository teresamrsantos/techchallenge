package com.challenge.challenge.transports;

import com.challenge.challenge.models.Pathology;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class SymptomDTO {
    private UUID uuid;
    private String description;
}
