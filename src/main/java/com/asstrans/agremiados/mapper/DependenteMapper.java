package com.asstrans.agremiados.mapper;

import com.asstrans.agremiados.dto.AssociadoDto;
import com.asstrans.agremiados.dto.UpdateDependenteDto;
import com.asstrans.agremiados.model.Associado;
import com.asstrans.agremiados.model.Dependente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DependenteMapper {

    Dependente toDependente(UpdateDependenteDto updateDependenteDto);

    UpdateDependenteDto toDependenteDto(Dependente dependente);
}
