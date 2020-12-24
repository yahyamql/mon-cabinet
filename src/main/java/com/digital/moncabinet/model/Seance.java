package com.digital.moncabinet.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
public class Seance {
    @Id
    private long id;
    private LocalDate dateSeance;
    private double amount;
    private String receipt;
    private String duration;
    private String comment;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Traitement traitement;
}
