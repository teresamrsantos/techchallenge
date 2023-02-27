package com.challenge.challenge.repositories;

import com.challenge.challenge.models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends
        JpaRepository<Speciality, Long>, JpaSpecificationExecutor<Speciality> {

    @Query("SELECT s FROM Speciality s JOIN s.doctorList d JOIN d.consultList c JOIN c.patient p GROUP BY s.id HAVING COUNT(DISTINCT p.id) > 2")
    List<Speciality> findSpecialitiesWithMoreThanTwoUniquePatients();
}


