package com.digital.moncabinet.mapper;

import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.enums.FamilySituationEnum;
import com.digital.moncabinet.model.Patient;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Mapper
public abstract class PatientMapper {

    public static PatientMapper INSTANCE = Mappers.getMapper( PatientMapper.class );

    public abstract Patient toEntity(PatientDto patientDto);

    public abstract PatientDto toDto(Patient patient);

    @AfterMapping
    public void toEntityAfterMapping(PatientDto patientDto,@MappingTarget Patient patient) {
        //patient .setFamilySituation(FamilySituationEnum.valueOf(patientDto.getFamilySituation()));
    }

    @AfterMapping
    public void toDtoAfterMapping(@MappingTarget PatientDto patientDto, Patient patient) {
        Optional.ofNullable(patient.getDateBirth()).ifPresent(e-> {
            patientDto.setAge(LocalDate.now().getYear() - e.getYear());
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            patientDto.setDateBirth(e.format(formatter));
        });
    }
}