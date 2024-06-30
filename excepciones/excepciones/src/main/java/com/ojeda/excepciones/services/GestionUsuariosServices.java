package com.ojeda.excepciones.services;

import com.ojeda.excepciones.dto.UsuarioDTO;
import com.ojeda.excepciones.dto.UsuariosDTO;
import com.ojeda.excepciones.model.GenericResponse;

public interface GestionUsuariosServices {
    public GenericResponse<UsuariosDTO> registroMasivo(String doc);
}
