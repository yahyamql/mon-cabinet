package com.digital.moncabinet.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class EventDto {
    private long id;
    private String title;
    private String backgroundColor;
    private ZonedDateTime start;
    private ZonedDateTime end;
    private ExtendedPropsDto extendedProps;
}

