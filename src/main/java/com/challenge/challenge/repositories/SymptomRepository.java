package com.challenge.challenge.repositories;

import com.challenge.challenge.models.Consult;
import com.challenge.challenge.models.Patient;
import com.challenge.challenge.models.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SymptomRepository extends JpaRepository<Consult, Long> {

    List<Symptom> findByConsult(Consult consult);
}