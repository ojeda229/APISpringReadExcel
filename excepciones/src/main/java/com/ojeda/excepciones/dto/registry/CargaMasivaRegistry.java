package com.ojeda.excepciones.dto.registry;

import com.ojeda.excepciones.constantes.Constantes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargaMasivaRegistry {
    @NotNull(message = Constantes.MENSAJE_VALIDATION + " urlArchivo")
    @Valid
    private String urlArchivo;

}
