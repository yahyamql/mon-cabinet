package com.digital.moncabinet.controller;


import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.mapper.PatientMapper;
import com.digital.moncabinet.model.Patient;

import com.digital.moncabinet.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("patient")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public void addPatient(@RequestBody PatientDto patientDto) {
        Patient patient = PatientMapper.INSTANCE.toEntity(patientDto);
        patientRepository.save(patient);
    }

    @GetMapping("/getAll")
    public List<PatientDto> getAllPatient() {
        List<PatientDto> listPatientDto = patientRepository.findAll().stream()
                .map(PatientMapper.INSTANCE::toDto).collect(Collectors.toList());
        return listPatientDto;
    }
}