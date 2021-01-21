package com.digital.moncabinet.dto;

import lombok.Data;
import java.time.ZonedDateTime;
@Data
public class SeanceDto {
    private long id;
    private String comment;
    private long idPatient;
    private String dateCreation;
    private ZonedDateTime dateSeance;
    private boolean confirm;
}