package com.ojeda.excepciones.exceptions;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionsDTO{
    private String mensaje;
    private String codigo;
    private List<String> detalles;
    
}
