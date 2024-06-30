package com.ojeda.readExcel.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ojeda.readExcel.dto.UsuariosDTO;
import com.ojeda.readExcel.dto.registry.CargaMasivaRegistry;
import com.ojeda.readExcel.enums.EnumExceptions;
import com.ojeda.readExcel.exceptions.APIException;
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
    
    @PostMapping(value = "/carga-masiva")
    @ResponseStatus(value = HttpStatus.OK)
    public GenericResponse<UsuariosDTO> registroMasivo( @RequestParam("archivo") @Valid @NotNull (message = "Es requerido") MultipartFile file) throws IOException{
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEE");
        System.err.println(file.getOriginalFilename());    
        return gestionUsuariosServices.registroMasivo(file);
    }
}
