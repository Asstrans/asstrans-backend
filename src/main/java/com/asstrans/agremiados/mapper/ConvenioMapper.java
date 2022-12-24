package com.asstrans.agremiados.mapper;

import com.asstrans.agremiados.dto.ConvenioDto;
import com.asstrans.agremiados.model.Convenio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConvenioMapper {

    Convenio toConvenio(ConvenioDto convenioDto);

    ConvenioDto toConvenioDto(Convenio convenio);

    ConvenioDto toConvenioDto(ConvenioDto convenioDto);


    Convenio toConvenio(Convenio convenio);
}
