package com.ojeda.excepciones.exceptions;

import java.util.List;

import com.ojeda.excepciones.enums.EnumExceptions;

import lombok.Data;

@Data
public class APIException extends RuntimeException{
    private List<String> detalles;
    private EnumExceptions enumExceptions;
    public APIException(List<String> detalles, EnumExceptions enumExceptions) {
        super(enumExceptions.getMensaje());
        this.detalles = detalles;
        this.enumExceptions = enumExceptions;
    } 
    


}