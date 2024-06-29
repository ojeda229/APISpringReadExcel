package com.ojeda.excepciones.model;


import java.util.List;

import lombok.Data;

@Data
public class GenericResponse<T> {
    private String mensaje;
    private List<T> body;

    public GenericResponse(String mensaje, List<T> body){
        this.mensaje = mensaje;
        this.body = body;
    }
}
