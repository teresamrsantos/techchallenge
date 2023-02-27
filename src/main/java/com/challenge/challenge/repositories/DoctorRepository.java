package com.challenge.challenge.repositories;

import com.challenge.challenge.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
