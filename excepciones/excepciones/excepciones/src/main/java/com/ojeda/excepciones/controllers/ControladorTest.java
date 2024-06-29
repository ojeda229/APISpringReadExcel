package com.ojeda.excepciones.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ojeda.excepciones.dto.UsuarioDTO;
import com.ojeda.excepciones.dto.registry.CargaMasivaRegistry;
import com.ojeda.excepciones.enums.EnumExceptions;
import com.ojeda.excepciones.exceptions.APIException;
import com.ojeda.excepciones.model.GenericResponse;
import com.ojeda.excepciones.services.GestionUsuariosServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/usuarios/v1/")
@AllArgsConstructor
public class ControladorTest {
    private GestionUsuariosServices gestionUsuariosServices;
    
    @PostMapping(value = "/carga-masiva-documentos")
    @ResponseStatus(value = HttpStatus.OK)
    public GenericResponse<UsuarioDTO> registroMasivo( @RequestBody @Valid CargaMasivaRegistry request){
        try{
            return gestionUsuariosServices.registroMasivo(request.getUrlArchivo());

        }catch(Exception e){
            List<String> detalles = Collections.singletonList(e.getCause().toString());
            throw new APIException(detalles, EnumExceptions.E500);
        }
    }
}
