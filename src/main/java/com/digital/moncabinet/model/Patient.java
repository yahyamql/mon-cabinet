package com.digital.moncabinet.model;

import com.digital.moncabinet.enums.FamilySituationEnum;
import com.digital.moncabinet.enums.GenderEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String insurance;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Enumerated(EnumType.STRING)
    private FamilySituationEnum familySituationEnum;
    private String tel;
    private short age;
    private LocalDateTime dateCreation;
    private ZonedDateTime dateBirth;
    @OneToMany(mappedBy = "patient")
    private List<Seance> listSeance;
    private int numberChildren;

    public Patient() {
        this.dateCreation = LocalDateTime.now();
    }
}
