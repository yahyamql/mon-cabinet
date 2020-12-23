package com.digital.moncabinet.mapper;

import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.model.Patient;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    public  static PatientMapper INSTANCE = Mappers.getMapper( PatientMapper.class );

    public  Patient toEntity(PatientDto patientDto);

    public  PatientDto toDto(Patient patient);

}
