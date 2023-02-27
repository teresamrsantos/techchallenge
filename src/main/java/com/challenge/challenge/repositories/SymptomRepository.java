package com.challenge.challenge.repositories;

import com.challenge.challenge.models.Consult;
import com.challenge.challenge.models.Patient;
import com.challenge.challenge.models.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SymptomRepository extends JpaRepository<Consult, Long> {

    @Query("SELECT s FROM Symptom s JOIN s.pathologyList p JOIN p.patientList pat WHERE pat.id = :patientId")
    List<Symptom> findAllSymptomsByPatientId(@Param("patientId") Long patientId);

}