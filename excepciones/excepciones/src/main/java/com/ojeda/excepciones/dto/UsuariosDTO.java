package com.ojeda.excepciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
public class UsuariosDTO {
    private List<UsuarioDTO> usuarios;

    public UsuariosDTO(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    
}
