package com.digital.moncabinet.mapper;

import com.digital.moncabinet.dto.SeanceDto;
import com.digital.moncabinet.model.Seance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeanceMapper {

    SeanceMapper INSTANCE = Mappers.getMapper( SeanceMapper.class );

    Seance toEntity(SeanceDto seanceDto);

    SeanceDto toDto(Seance seance);
}
