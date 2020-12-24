package com.digital.moncabinet.repo;

import com.digital.moncabinet.model.Patient;
import com.digital.moncabinet.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository  extends JpaRepository<Seance, Long> {

}

