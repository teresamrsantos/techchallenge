package com.challenge.challenge.models;

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
@Table(name = "doctor")
public class Doctor extends EntityBase {

    @Column(name = "name")
    @NotNull
    private String name;

    @OneToMany(mappedBy = "doctor")
    private List<Consult> consultList;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "speciality", nullable = false)
    private Speciality speciality;
}
