package com.challenge.challenge.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "consult")
public class Consult extends EntityBase {

    @ManyToOne
    @NotNull
    @JoinColumn(name = "patient", nullable = false)
    private Patient patient;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "doctor", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "speciality", nullable = false)
    private Speciality speciality;
}
