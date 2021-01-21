package com.digital.moncabinet.repo;

import com.digital.moncabinet.model.Patient;
import com.digital.moncabinet.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface SeanceRepository  extends JpaRepository<Seance, Long> {


    List<Seance> findByStartAfterAndEndBefore(ZonedDateTime start, ZonedDateTime end);
}

