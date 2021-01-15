package com.digital.moncabinet.mapper;

import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.enums.FamilySituationEnum;
import com.digital.moncabinet.model.Patient;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.Optional;

@Mapper
public abstract class PatientMapper {

    public static PatientMapper INSTANCE = Mappers.getMapper( PatientMapper.class );

    public abstract Patient toEntity(PatientDto patientDto);

    public abstract PatientDto toDto(Patient patient);

    @AfterMapping
    public void toEntityAfterMapping(PatientDto patientDto,@MappingTarget Patient patient) {
        patient.setFamilySituationEnum(FamilySituationEnum.valueOf(patientDto.getFamilySituation()));
    }

    @AfterMapping
    public void completeAttributes(@MappingTarget PatientDto patientDto, Patient patient) {
        Optional.ofNullable(patient.getDateBirth()).ifPresent(e-> {
            patientDto.setAge(LocalDate.now().getYear() - e.getYear());
        });
    }
}