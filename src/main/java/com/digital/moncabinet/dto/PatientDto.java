package com.digital.moncabinet.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
public class PatientDto implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private int tel;
}
