package br.com.pedro.Ecommerceapi.exceptions;

import br.com.pedro.Ecommerceapi.dtos.DefaultError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.util.Date;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handleException(SQLIntegrityConstraintViolationException e){

        Date dateNow = new Date();

        DefaultError error = new DefaultError(HttpStatus.BAD_GATEWAY.value(), "Error sql",dateNow, e.getMessage());

    return new ResponseEntity(error, HttpStatus.BAD_GATEWAY);
    }

}
