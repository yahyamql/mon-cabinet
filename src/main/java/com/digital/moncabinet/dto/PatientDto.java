package com.digital.moncabinet.dto;

import lombok.*;

import java.io.Serializable;

@Data
public class PatientDto  {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private String dateCreation;
    private int tel;
}
