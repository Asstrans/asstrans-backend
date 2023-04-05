package com.asstrans.agremiados.mapper;

import com.asstrans.agremiados.dto.PlanoDto;
import com.asstrans.agremiados.dto.UpdatePlanoDto;
import com.asstrans.agremiados.model.Plano;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PlanoMapper {
    Plano toPlano(PlanoDto planoDto);
    PlanoDto toPlanoDto(Plano plano);

    Plano toPlano(UpdatePlanoDto updatePlanoDto);

}
