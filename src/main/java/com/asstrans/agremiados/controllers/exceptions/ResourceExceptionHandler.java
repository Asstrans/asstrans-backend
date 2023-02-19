package com.asstrans.agremiados.controllers.exceptions;

import com.asstrans.agremiados.services.exceptions.LimiteExcedidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(LimiteExcedidoException.class)
    public ResponseEntity<StandarError> limiteException(LimiteExcedidoException exception, HttpServletRequest request) {
        StandarError standarError = new StandarError(Instant.now(),
                                                     HttpStatus.BAD_REQUEST.value(),
                                                     "Limite excedido",
                                                     exception.getMessage(),
                                                     request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standarError);
    }
}
