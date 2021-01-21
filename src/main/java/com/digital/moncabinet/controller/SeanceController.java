package com.digital.moncabinet.controller;

import com.digital.moncabinet.dto.EventDto;
import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.mapper.PatientMapper;
import com.digital.moncabinet.mapper.SeanceMapper;
import com.digital.moncabinet.model.Patient;
import com.digital.moncabinet.model.Seance;
import com.digital.moncabinet.repo.PatientRepository;
import com.digital.moncabinet.repo.SeanceRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("seance")
@CrossOrigin("*")
public class SeanceController {
    List<EventDto> list;
    public SeanceController() {
        list = new ArrayList<>();

    }
    static long ID = 1L;

    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/get-patient")
    public List<PatientDto> getPatientByFirstNameOrLastName(@RequestParam String keyword) {
        List<PatientDto> listPatientDto = patientRepository.findByFirstNameOrLastName(keyword).stream()
                .map(PatientMapper.INSTANCE::toDto).collect(Collectors.toList());
        return listPatientDto;
    }
/*
    @PostMapping
    public void addSeance(@RequestBody SeanceDto seanceDto) {
        Seance seance = SeanceMapper.INSTANCE.toEntity(seanceDto);
        Optional<Patient> p = patientRepository.findById(seanceDto.getIdPatient());
        seance.setPatient(p.get());
        seanceRepository.save(seance);
    }

   @GetMapping
    public List<SeanceDto> getAllSeances() {
        List<SeanceDto> listSeanceDto = seanceRepository.findAll().stream()
                .map(SeanceMapper.INSTANCE::toDto).collect(Collectors.toList());
        return listSeanceDto;
    }
         */

    @DeleteMapping("/{id}")
    public void deleteSeance(@PathVariable long id) {
        System.out.println("deleteSeance : " + id);
        seanceRepository.deleteById(id);
        System.out.println("list.size() : " + list.size());
    }


    @PostMapping
    public void addSeance(@RequestBody EventDto eventDto) {
        eventDto.setEnd(eventDto.getStart().plusMinutes(30));
        Seance seance = SeanceMapper.INSTANCE.toEntity(eventDto);
        patientRepository.findById(eventDto.getExtendedProps().getIdPatient()).
                ifPresent(e-> {
                    seance.setPatient(e);
                    seanceRepository.save(seance);
                });
    }

    @GetMapping
    public List<EventDto> getAllSeances(@RequestParam
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                 ZonedDateTime start,
                                        @RequestParam
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                             ZonedDateTime end) {
        List<Seance> listSeance =
                this.seanceRepository.findByStartAfterAndEndBefore(start, end);
        List<EventDto> listEventDto =
                listSeance.stream().map(SeanceMapper.INSTANCE::toDto).collect(Collectors.toList());
        System.out.println("getAllSeances size==" + listEventDto.size());
        return listEventDto;
    }

    @PutMapping
    public void updateSeance(@RequestBody EventDto eventDto) {
        Seance seance = SeanceMapper.INSTANCE.toEntity(eventDto);
        this.seanceRepository.save(seance);
    }
}