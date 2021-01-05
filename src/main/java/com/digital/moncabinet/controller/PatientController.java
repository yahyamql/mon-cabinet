package com.digital.moncabinet.controller;

import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.mapper.PatientMapper;
import com.digital.moncabinet.model.Patient;

import com.digital.moncabinet.repo.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("patient")
@CrossOrigin("*")
public class PatientController {

    private PatientRepository patientRepository;

    @PostMapping
    public void addPatient(@RequestBody PatientDto patientDto) {
        Patient patient = PatientMapper.INSTANCE.toEntity(patientDto);
        patientRepository.save(patient);
    }

    @GetMapping
    public List<PatientDto> getAllPatient() {
        List<PatientDto> listPatientDto = patientRepository.findAll().stream()
                .map(PatientMapper.INSTANCE::toDto).collect(Collectors.toList());
        return listPatientDto;
    }

    @PutMapping("/{id}")
    public void updatePatient(@PathVariable long id,
            @RequestBody PatientDto patientDto) {
        patientDto.setId(id);
        Patient patient = PatientMapper.INSTANCE.toEntity(patientDto);
        patientRepository.save(patient);
    }

    @GetMapping("/{id}")
    public void getPatient(@PathVariable long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        Patient patientExist =
        Optional.ofNullable(patient.get()).orElseThrow(IllegalArgumentException::new);
        patientRepository.save(patientExist);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable long id) {
        patientRepository.deleteById(id);
    }

}