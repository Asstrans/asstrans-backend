package com.asstrans.agremiados.mapper;

import com.asstrans.agremiados.dto.AssociadoDto;
import com.asstrans.agremiados.model.Associado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssociadoMapper {

    Associado toAssociado(AssociadoDto associadoDto);

    AssociadoDto toAssociadoDto(Associado associado);
}
