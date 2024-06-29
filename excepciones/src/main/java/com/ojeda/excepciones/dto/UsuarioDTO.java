package com.ojeda.excepciones.dto;

import com.ojeda.excepciones.constantes.Constantes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    //@NotNull(message = Constantes.MENSAJE_VALIDATION + "numeroEmpleado")
    //@Valid
    private String numeroEmpleado;
    
    //@NotNull(message = Constantes.MENSAJE_VALIDATION + "numeroEmpleado")
    //@Valid
    private String nombre;
    
    //@NotNull(message = Constantes.MENSAJE_VALIDATION + "numeroEmpleado")
    //@Valid
    private String apellidoPaterno;
    
    //@NotNull(message = Constantes.MENSAJE_VALIDATION + " numeroEmpleado")
    //@Valid
    private String apellidoMaterno;
    
    //@NotNull(message = Constantes.MENSAJE_VALIDATION + " numeroEmpleado")
    //@Valid
    private String puesto;
}
