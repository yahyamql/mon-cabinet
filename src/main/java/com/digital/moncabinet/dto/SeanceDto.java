package com.digital.moncabinet.dto;

import lombok.Data;

@Data
public class SeanceDto {
    private long id;
    private String comment;
    private PatientDto patient;
    private String dateCreation;
    private String dateSeance;
    private boolean confirm;
}