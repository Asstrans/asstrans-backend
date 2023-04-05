package com.asstrans.agremiados.controllers.exceptions;

import com.asstrans.agremiados.services.exceptions.LimiteExcedidoException;
import com.asstrans.agremiados.services.exceptions.PlanoIntegrityException;
import com.asstrans.agremiados.services.exceptions.VerifyPlanoAssociadoExistException;
import org.springframework.dao.DataIntegrityViolationException;
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

    @ExceptionHandler(VerifyPlanoAssociadoExistException.class)
    public ResponseEntity<StandarError> verifyPlanoAssociadoExistException(VerifyPlanoAssociadoExistException exception, HttpServletRequest request) {
        StandarError standarError = new StandarError(Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Associado já existe para esse plano",
                exception.getMessage(),
                request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standarError);
    }

    @ExceptionHandler(PlanoIntegrityException.class)
    public ResponseEntity<StandarError> planoIntegrityException(PlanoIntegrityException exception, HttpServletRequest request) {
        StandarError standarError = new StandarError(Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Plano possui processos que não podem ser excluídos",
                exception.getMessage(),
                request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standarError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandarError> dataIntegrityException(DataIntegrityViolationException exception, HttpServletRequest request) {
        StandarError standarError = new StandarError(Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "tabela possui processos que não podem ser excluídos",
                "tabela possui processos que não podem ser excluídos",
                request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standarError);
    }
}
