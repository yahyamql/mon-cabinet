package com.digital.moncabinet.mapper;

import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.model.Patient;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Mapper
public abstract class PatientMapper {

    public  static PatientMapper INSTANCE = Mappers.getMapper( PatientMapper.class );

    public abstract Patient toEntity(PatientDto patientDto);

    public abstract PatientDto toDto(Patient patient);

    @AfterMapping
    public void initDateCreation(PatientDto patientDto,@MappingTarget Patient patient) {
        if(StringUtils.isEmpty(patientDto.getDateCreation())) {
            patient.setDateCreation(LocalDateTime.now());
        }
        Optional.ofNullable(patientDto.getDateBirth()).ifPresent(e-> {
            patient.setDateBirth(LocalDate.parse(e));
        });

    }
}