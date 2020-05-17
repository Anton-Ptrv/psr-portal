package com.rined.psr.portal.controller.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.rined.psr.portal.model.dto.ErrorResponse;
import com.rined.psr.portal.exception.AlreadyExistsException;
import com.rined.psr.portal.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler({AlreadyExistsException.class})
    public ErrorResponse alreadyExists(AlreadyExistsException e) {
        log.warn("Already exists", e);
        return ErrorResponse.of("Conflict!", e);
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ErrorResponse notFound(NotFoundException e) {
        log.warn("Bean not found", e);
        return ErrorResponse.of("Bean not found!", e);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class, JsonMappingException.class, MethodArgumentNotValidException.class})
    public ErrorResponse badRequest(BindException e) {
        log.warn("Bad request", e);
        return ErrorResponse.of("Bad request!", e);
    }
}
