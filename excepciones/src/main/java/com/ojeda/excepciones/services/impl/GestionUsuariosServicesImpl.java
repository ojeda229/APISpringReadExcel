package com.ojeda.excepciones.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.ojeda.excepciones.constantes.Constantes;
import com.ojeda.excepciones.dto.UsuarioDTO;
import com.ojeda.excepciones.enums.EnumExceptions;
import com.ojeda.excepciones.exceptions.APIException;
import com.ojeda.excepciones.model.GenericResponse;
import com.ojeda.excepciones.services.GestionUsuariosServices;

@Service
public class GestionUsuariosServicesImpl implements GestionUsuariosServices{

    public GenericResponse<UsuarioDTO> registroMasivo(String doc) {
        
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try{
            File archivo = new File(doc);
            FileInputStream byteArchivo = new FileInputStream(archivo); 
            XSSFWorkbook workbook = new XSSFWorkbook(byteArchivo);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for(Row row: sheet){
                try{
                    UsuarioDTO usuario = new UsuarioDTO();
                    usuario.setNumeroEmpleado(row.getCell(0).getStringCellValue());
                    usuario.setNombre(row.getCell(1).getStringCellValue());
                    usuario.setApellidoPaterno(row.getCell(2).getStringCellValue());
                    usuario.setApellidoMaterno(row.getCell(3).getStringCellValue());
                    usuario.setPuesto(row.getCell(4).getStringCellValue());
                    usuarios.add(usuario);
                }catch(NullPointerException e){
                    List<String> detalles = Collections.singletonList(e.getMessage());
                    throw new APIException(detalles, EnumExceptions.E404);
                }
                
            }
            workbook.close();
            byteArchivo.close();
        }catch(FileNotFoundException e){
            List<String> detalles = Collections.singletonList(e.getMessage());
            throw new APIException(detalles, EnumExceptions.E404);
        }catch(Exception e){
            List<String> detalles = Collections.singletonList(e.getMessage());
            throw new APIException(detalles, EnumExceptions.E500);
        }
        
        return new GenericResponse<UsuarioDTO>(Constantes.MENSAJE_EXITO,usuarios);
    }
}
