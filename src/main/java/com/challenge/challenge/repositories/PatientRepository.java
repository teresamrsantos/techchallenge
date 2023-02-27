package com.challenge.challenge.repositories;

import com.challenge.challenge.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends
        JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {

    Optional<Patient> findPatientById(Long uuid);

}




