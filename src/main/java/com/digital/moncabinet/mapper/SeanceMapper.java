package com.digital.moncabinet.mapper;

import com.digital.moncabinet.dto.EventDto;
import com.digital.moncabinet.dto.PatientDto;
import com.digital.moncabinet.model.Patient;
import com.digital.moncabinet.model.Seance;
import org.apache.commons.validator.GenericValidator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Mapper
public abstract class SeanceMapper {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyy-MM-dd");

    public static SeanceMapper INSTANCE = Mappers.getMapper( SeanceMapper.class );

    /*public Seance toEntity(SeanceDto seanceDto) {
        Seance seance = new Seance();
        seance.setComment(seanceDto.getComment());
        if (GenericValidator.isDate(seanceDto.getDateSeance(), "yyyy-MM-dd", true)) {
            LocalDate localDate = LocalDate.parse(seanceDto.getDateSeance(), DATE_FORMATTER);
            LocalDateTime localDateTime = localDate.atTime(12,00,00);
            ZonedDateTime zonedDateTime =
            localDateTime.atZone(ZoneId.systemDefault());
            seance.setDateSeance(zonedDateTime);
        } else {
            seance.setDateSeance( ZonedDateTime.parse( seanceDto.getDateSeance()));
        }
        return seance;
    }*/

    @Mappings({@Mapping(source = "extendedProps.confirm", target = "confirm"),
            @Mapping(source = "extendedProps.comment", target = "comment")})
    public abstract Seance toEntity(EventDto eventDto);

    @Mappings({@Mapping(source = "confirm", target = "extendedProps.confirm"),
                    @Mapping(source = "comment", target = "extendedProps.comment")})
    public abstract EventDto toDto(Seance seance);

    @AfterMapping
    public void toDtoAfterMapping(@MappingTarget EventDto eventDto, Seance seance) {
        eventDto.setTitle(
                seance.getPatient().getFirstName() + " " + seance.getPatient().getLastName());
    }
}
