package com.challenge.challenge.repositories;

import com.challenge.challenge.models.Consult;
import com.challenge.challenge.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultRepository extends JpaRepository<Consult, Long> {

    @Query("SELECT COUNT(DISTINCT c.patient.id) FROM Consult c WHERE c.speciality.id =:specialityID")
    Long countDistinctPatientsBySpeciality(@Param("specialityID") Long id);

    List<Consult> findAllByPatient(Patient patient);
}