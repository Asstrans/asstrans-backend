package com.asstrans.agremiados.services;

import com.asstrans.agremiados.dto.RequisicaoDto;
import com.asstrans.agremiados.model.Requisicao;

public interface RequisicaoService {

    public Requisicao save(RequisicaoDto requisicaoDto);
}
