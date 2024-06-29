package com.ojeda.excepciones.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ojeda.excepciones.enums.EnumExceptions;

@RestControllerAdvice
public class HandleException {

    /**
     * @return
     */
    @ExceptionHandler(value = { APIException.class })
    public ResponseEntity<ExceptionsDTO> exceptionesAPI(APIException e) {

        ExceptionsDTO respuesta = new ExceptionsDTO(e.getEnumExceptions().getMensaje(),
                e.getEnumExceptions().getCodigo(), e.getDetalles());
        ResponseEntity<ExceptionsDTO> responseException;
        switch (e.getEnumExceptions()) {
            case E400:
                responseException = new ResponseEntity<ExceptionsDTO>(respuesta, HttpStatus.BAD_REQUEST);
                break;

            case E401:
                responseException = new ResponseEntity<ExceptionsDTO>(respuesta, HttpStatus.UNAUTHORIZED);
                break;

            default:
                responseException = new ResponseEntity<ExceptionsDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
                break;
        }
        return responseException;
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<ExceptionsDTO> MethodArgumentNotValidExceptionResponse(MethodArgumentNotValidException e) {
        ExceptionsDTO respuesta = new ExceptionsDTO(
            EnumExceptions.E400.getMensaje(), 
            EnumExceptions.E400.getCodigo(),
            getErrors(e.getFieldErrors()));
        ResponseEntity<ExceptionsDTO> responseException;
        return new ResponseEntity<ExceptionsDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = { HttpMessageNotReadableException.class })
    public ResponseEntity<ExceptionsDTO> HttpMessageNotReadableExceptionResponse(MethodArgumentNotValidException e) {
        ExceptionsDTO respuesta = new ExceptionsDTO(
            EnumExceptions.E400.getMensaje(), 
            EnumExceptions.E400.getCodigo(),
            getErrors(e.getFieldErrors()));
        ResponseEntity<ExceptionsDTO> responseException;
        return new ResponseEntity<ExceptionsDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    

    public List<String> getErrors(List<FieldError> errores ){
        List<String> detallesError = new ArrayList<>();
        for(FieldError error:errores){
            detallesError.add(error.getDefaultMessage());
        }
        return detallesError;
    }
}
