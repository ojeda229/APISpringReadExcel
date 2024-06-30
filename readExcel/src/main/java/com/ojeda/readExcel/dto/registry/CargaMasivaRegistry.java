package com.ojeda.readExcel.dto.registry;

import org.springframework.web.multipart.MultipartFile;

import com.ojeda.readExcel.constantes.Constantes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargaMasivaRegistry {
    @NotNull(message = Constantes.MENSAJE_VALIDATION + " archivo")
    @Valid
    private MultipartFile archivo;

}
