package com.ojeda.excepciones.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.ojeda.excepciones.constantes.Constantes;
import com.ojeda.excepciones.dto.UsuarioDTO;
import com.ojeda.excepciones.dto.UsuariosDTO;
import com.ojeda.excepciones.enums.EnumExceptions;
import com.ojeda.excepciones.exceptions.APIException;
import com.ojeda.excepciones.model.GenericResponse;
import com.ojeda.excepciones.services.GestionUsuariosServices;

@Service
public class GestionUsuariosServicesImpl implements GestionUsuariosServices {
    public GenericResponse<UsuariosDTO> registroMasivo(String doc) { 
        List<UsuarioDTO> listUsuarios= new ArrayList<>();
        try{
            File archivo = new File(doc);
            FileInputStream byteArchivo = new FileInputStream("excepciones\\src\\docs\\test.xlsx"); 
            XSSFWorkbook workbook = new XSSFWorkbook(byteArchivo);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for(Row row: sheet){
                if (row.getRowNum() != 0) {
                    UsuarioDTO usuario = new UsuarioDTO();
                    usuario.setNumeroEmpleado(getCellValueAsString(row.getCell(0)));
                    usuario.setNombre(getCellValueAsString(row.getCell(1)));
                    usuario.setApellidoPaterno(getCellValueAsString(row.getCell(2)));
                    usuario.setApellidoMaterno(getCellValueAsString(row.getCell(3)));
                    usuario.setPuesto(getCellValueAsString(row.getCell(4)));
                    listUsuarios.add(usuario);
                }
            }
            UsuariosDTO usuarios = new UsuariosDTO(listUsuarios);
            workbook.close();
            byteArchivo.close();
            return new GenericResponse<UsuariosDTO>(Constantes.MENSAJE_EXITO, usuarios);
        }catch(FileNotFoundException e){
            List<String> detalles = Collections.singletonList(e.getMessage());
            throw new APIException(detalles, EnumExceptions.E404);
        }catch(Exception e){
            List<String> detalles = Collections.singletonList(e.getMessage());
            throw new APIException(detalles, EnumExceptions.E500);
        }
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        CellType cellType = cell.getCellType();

        switch (cellType) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "Tipo de celda no soportado";
        }
    }
}