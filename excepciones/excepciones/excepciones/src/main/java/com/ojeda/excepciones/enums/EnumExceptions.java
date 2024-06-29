package com.ojeda.excepciones.enums;

import com.ojeda.excepciones.constantes.Constantes;

public enum EnumExceptions {
    E400(
        Constantes.PROXY + "400",
        Constantes.MENSAJE_ERROR + " Parámetros de entrada no válidos"
    ),
    
    E404(
        Constantes.PROXY + "404",
        Constantes.MENSAJE_ERROR + " Recursos no encontrados"
    ),

    E401(
        Constantes.PROXY +"401",
        Constantes.MENSAJE_ERROR + " No estás autorizado"
    ),
    
    E500(
        Constantes.PROXY +"500",
        Constantes.MENSAJE_ERROR + " Error interno"
    );

    private EnumExceptions(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }
    private String codigo;
    private String mensaje;
    public String getCodigo() {
        return codigo;
    }
    public String getMensaje() {
        return mensaje;
    }
    
    
    
    
}