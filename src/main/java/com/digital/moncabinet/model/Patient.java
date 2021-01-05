package com.digital.moncabinet.model;

import com.digital.moncabinet.enums.FamilySituationEnum;
import com.digital.moncabinet.enums.GenderEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String insurance;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Enumerated(EnumType.STRING)
    private FamilySituationEnum familySituationEnum;
    private String tel;
    private short age;
    private LocalDateTime dateCreation;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateBirth;
    @OneToMany(mappedBy = "patient")
    private List<Seance> listSeance;
    private int numberChildren;
}
