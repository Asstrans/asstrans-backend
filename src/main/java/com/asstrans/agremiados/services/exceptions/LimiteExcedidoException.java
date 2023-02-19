package com.asstrans.agremiados.services.exceptions;

public class LimiteExcedidoException extends  RuntimeException{

    public LimiteExcedidoException(String message) {
        super(message);
    }
}
