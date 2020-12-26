package com.digital.moncabinet.dto;

import lombok.*;

@Data
public class PatientDto  {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private String dateCreation;
    private String dateBirth;
    private int age;
    private long tel;
}
