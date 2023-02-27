package com.challenge.challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "speciality")
public class Speciality extends EntityBase {

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<Doctor> doctorList;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<Consult> consultList;
}
