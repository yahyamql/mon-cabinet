package com.digital.moncabinet.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime dateSeance;
    private double amount;
    private String receipt;
    private String duration;
    private String comment;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Traitement traitement;
}
