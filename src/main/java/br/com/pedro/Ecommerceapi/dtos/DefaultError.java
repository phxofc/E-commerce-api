package br.com.pedro.Ecommerceapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class DefaultError{

    private Integer code;
    private String message;
    private Date date;
    private String exception;
}
