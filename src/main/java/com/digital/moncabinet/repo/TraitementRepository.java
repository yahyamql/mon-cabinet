package com.digital.moncabinet.repo;

import com.digital.moncabinet.model.Patient;
import com.digital.moncabinet.model.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitementRepository extends JpaRepository<Traitement, Long> {

}
