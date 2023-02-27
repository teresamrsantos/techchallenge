package com.challenge.challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "symptom")
public class Symptom extends EntityBase {

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "symptomList")
    @JsonIgnore
    private List<Pathology> pathologyList;
}