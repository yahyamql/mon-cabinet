package com.digital.moncabinet.controller;

import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.mapper.PatientMapper;
import com.digital.moncabinet.repo.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("seance")
@CrossOrigin("*")
public class SeanceController {

    private PatientRepository patientRepository;

    @GetMapping("/get-patient")
    public List<PatientDto> getPatientByFirstNameOrLastName(@RequestParam String keyword) {
        System.out.println("keyword : " + keyword);
        List<PatientDto> listPatientDto = patientRepository.findByFirstNameOrLastName(keyword).stream()
                .map(PatientMapper.INSTANCE::toDto).collect(Collectors.toList());

        System.out.println("size : " + listPatientDto.size());
        return listPatientDto;
    }
}