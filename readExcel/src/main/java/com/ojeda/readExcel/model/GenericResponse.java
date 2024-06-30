package com.ojeda.readExcel.model;



import lombok.Data;

@Data
public class GenericResponse<T> {
    private String mensaje;
    private T body;

    public GenericResponse(String mensaje, T body){
        this.mensaje = mensaje;
        this.body = body;
    }
}
