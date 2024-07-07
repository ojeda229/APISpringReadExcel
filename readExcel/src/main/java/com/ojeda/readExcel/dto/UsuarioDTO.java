package com.ojeda.readExcel.dto;


import com.ojeda.readExcel.constantes.Constantes;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    @NotNull(message = Constantes.MENSAJE_VALIDATION + "numeroEmpleado")
    @Valid
    private String numeroEmpleado;
    
    @NotNull(message = Constantes.MENSAJE_VALIDATION + "numeroEmpleado")
    @Valid
    private String nombre;
    
    @NotNull(message = Constantes.MENSAJE_VALIDATION + "numeroEmpleado")
    @Valid
    private String apellidoPaterno;
    
    @NotNull(message = Constantes.MENSAJE_VALIDATION + " numeroEmpleado")
    @Valid
    private String apellidoMaterno;
    
    @NotNull(message = Constantes.MENSAJE_VALIDATION + " numeroEmpleado")
    @Valid
    private String puesto;
}
