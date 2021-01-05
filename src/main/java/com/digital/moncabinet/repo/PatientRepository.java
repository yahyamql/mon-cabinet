package com.digital.moncabinet.repo;

import com.digital.moncabinet.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p " +
            "WHERE p.firstName LIKE %:keyword% OR p.lastName LIKE %:keyword%")
    List<Patient> findByFirstNameOrLastName(String keyword);
}