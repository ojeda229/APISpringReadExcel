package com.ojeda.readExcel.services;


import org.springframework.web.multipart.MultipartFile;

import com.ojeda.readExcel.dto.UsuariosDTO;
import com.ojeda.readExcel.model.GenericResponse;

public interface GestionUsuariosServices {
    public GenericResponse<UsuariosDTO> registroMasivo(MultipartFile file);
}
