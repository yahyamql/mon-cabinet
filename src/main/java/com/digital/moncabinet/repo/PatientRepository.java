package com.digital.moncabinet.repo;

import com.digital.moncabinet.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
