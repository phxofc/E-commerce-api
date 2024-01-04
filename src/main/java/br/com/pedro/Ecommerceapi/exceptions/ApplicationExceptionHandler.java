package br.com.pedro.Ecommerceapi.exceptions;

import br.com.pedro.Ecommerceapi.dtos.DefaultError;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.Date;
import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handleException(SQLIntegrityConstraintViolationException e){

        Date dateNow = new Date();

        DefaultError error = new DefaultError(HttpStatus.BAD_GATEWAY.value(), "Error sql",dateNow, e.getMessage());

    return new ResponseEntity(error, HttpStatus.BAD_GATEWAY);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleException(NotFoundException e){

        Date dateNow = new Date();

        DefaultError error = new DefaultError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "ID NOT FOUND ",dateNow, e.getMessage());

        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity handleException(NoSuchElementException e){

        Date dateNow = new Date();

        DefaultError error = new DefaultError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "ID NOT FOUND ",dateNow, e.getMessage());

        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(IncorrectLoginException.class)
    public ResponseEntity handleException(IncorrectLoginException e){

        Date dateNow = new Date();

        DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.value(), "username/password incorrect ",dateNow, e.getMessage());

        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }




}
