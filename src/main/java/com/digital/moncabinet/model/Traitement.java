package com.digital.moncabinet.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Traitement {
    @Id
    private long id;
    private String type;
    private String description;
    private double amount;
    @OneToMany(mappedBy = "traitement")
    private List<Seance> listSeance;


}
