package com.challenge.challenge.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pathology")
public class Pathology extends EntityBase {

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "symptom_pathology",
            joinColumns = @JoinColumn(name = "pathology_id"),
            inverseJoinColumns = @JoinColumn(name = "symptom_id")
    )
    private List<Symptom> symptomList;


    @ManyToMany
    @JoinTable(
            name = "patient_pathology",
            joinColumns = @JoinColumn(name = "pathology_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patientList;
}