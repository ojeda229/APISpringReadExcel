package com.ojeda.readExcel.exceptions;

import java.util.List;

import com.ojeda.readExcel.enums.EnumExceptions;

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