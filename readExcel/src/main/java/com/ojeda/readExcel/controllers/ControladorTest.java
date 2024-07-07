package com.ojeda.readExcel.controllers;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ojeda.readExcel.constantes.Constantes;
import com.ojeda.readExcel.dto.UsuariosDTO;
import com.ojeda.readExcel.dto.registry.DocumentRegistry;
import com.ojeda.readExcel.model.GenericResponse;
import com.ojeda.readExcel.services.GestionUsuariosServices;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/usuarios/v1/")
@AllArgsConstructor
public class ControladorTest {
    private GestionUsuariosServices gestionUsuariosServices;
    
    @PostMapping(value = "/registroMasivo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public GenericResponse<UsuariosDTO> registroMasivo(
            @NotNull(message = Constantes.MENSAJE_VALIDATION + " archivo") 
            @Valid @RequestParam("archivo") MultipartFile archivo) {
        return gestionUsuariosServices.registroMasivo(archivo);
    }
}
