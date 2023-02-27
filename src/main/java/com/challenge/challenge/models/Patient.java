package com.challenge.challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "patient")
public class Patient extends EntityBase {

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "age")
    @NotNull
    private Integer age;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Consult> consultList;

    @ManyToMany(mappedBy = "patientList")
    @JsonIgnore
    private List<Pathology> pathologyList;
}
