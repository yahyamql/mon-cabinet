package com.digital.moncabinet.mapper;

import com.digital.moncabinet.dto.SeanceDto;
import com.digital.moncabinet.model.Seance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeanceMapper {

    public  static SeanceMapper INSTANCE = Mappers.getMapper( SeanceMapper.class );

    public Seance toEntity(SeanceDto seanceDto);

    public SeanceDto toDto(Seance seance);
}
