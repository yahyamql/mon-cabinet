package com.digital.moncabinet.mapper;

import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.model.Patient;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Mapper
public abstract class PatientMapper {

    public  static PatientMapper INSTANCE = Mappers.getMapper( PatientMapper.class );

    @Mapping(target="dateBirth", source="patientDto.dateBirth",
            dateFormat="yyyy-MM-dd")
    public abstract Patient toEntity(PatientDto patientDto);

    public abstract PatientDto toDto(Patient patient);

    @AfterMapping
    public void initDateCreation(PatientDto patientDto,@MappingTarget Patient patient) {
        if(StringUtils.isEmpty(patientDto.getDateCreation())) {
            patient.setDateCreation(LocalDateTime.now());
        }
    }

    @AfterMapping
    public void competeAttributes(@MappingTarget PatientDto patientDto, Patient patient) {
        Optional.ofNullable(patient.getDateBirth()).ifPresent(e-> {
            patientDto.setAge(LocalDate.now().getYear() - e.getYear());
        });
    }

    @BeforeMapping
    public void initBirthDate(PatientDto patientDto,@MappingTarget Patient patient) {
        patientDto.setDateBirth(StringUtils.substringBefore(patientDto.getDateBirth(), "T"));
    }
}