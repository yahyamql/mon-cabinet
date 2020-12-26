package com.digital.moncabinet.model;


import com.digital.moncabinet.enums.GenderEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    private long tel;
    private short age;
    private LocalDateTime dateCreation;
    private LocalDate dateBirth;
    @OneToMany(mappedBy = "patient")
    private List<Seance> listSeance;
}
