package com.digital.moncabinet.model;


import com.digital.moncabinet.enums.GenderEnum;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Patient {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    private int tel;
    @CreatedDate
    private LocalDate dateCreated;
}
