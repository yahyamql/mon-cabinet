package com.digital.moncabinet.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Traitement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String description;
    private double amount;
    @OneToMany(mappedBy = "traitement")
    private List<Seance> listSeance;
}
