package br.com.dicasdeumdev.api.resource.exceptions;

import br.com.dicasdeumdev.api.service.exceptions.DataIntegratyViolationException;
import br.com.dicasdeumdev.api.service.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<br.com.dicasdeumdev.api.resource.exceptions.StandardError>objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
        br.com.dicasdeumdev.api.resource.exceptions.StandardError error =
                new br.com.dicasdeumdev.api.resource.exceptions.StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegratyViolationException.class)
    public ResponseEntity<br.com.dicasdeumdev.api.resource.exceptions.StandardError>dataIntegrityViolationException(DataIntegratyViolationException ex, HttpServletRequest request) {
        br.com.dicasdeumdev.api.resource.exceptions.StandardError error =
                new br.com.dicasdeumdev.api.resource.exceptions.StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
