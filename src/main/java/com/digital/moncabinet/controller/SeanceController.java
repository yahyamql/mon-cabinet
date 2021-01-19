package com.digital.moncabinet.controller;

import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.dto.SeanceDto;
import com.digital.moncabinet.mapper.PatientMapper;
import com.digital.moncabinet.mapper.SeanceMapper;
import com.digital.moncabinet.model.Patient;
import com.digital.moncabinet.model.Seance;
import com.digital.moncabinet.repo.PatientRepository;
import com.digital.moncabinet.repo.SeanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("seance")
@CrossOrigin("*")
public class SeanceController {

    private SeanceRepository seanceRepository;
    private PatientRepository patientRepository;

    @GetMapping("/get-patient")
    public List<PatientDto> getPatientByFirstNameOrLastName(@RequestParam String keyword) {
        List<PatientDto> listPatientDto = patientRepository.findByFirstNameOrLastName(keyword).stream()
                .map(PatientMapper.INSTANCE::toDto).collect(Collectors.toList());
        return listPatientDto;
    }

    @PostMapping
    public void addSeance(@RequestBody SeanceDto seanceDto) {
        Seance seance = SeanceMapper.INSTANCE.toEntity(seanceDto);
        Optional<Patient> p = patientRepository.findById(seanceDto.getIdPatient());
        seance.setPatient(p.get());
        seanceRepository.save(seance);
    }
}