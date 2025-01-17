package com.ojeda.readExcel.services.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ojeda.readExcel.constantes.Constantes;
import com.ojeda.readExcel.dto.UsuarioDTO;
import com.ojeda.readExcel.dto.UsuariosDTO;
import com.ojeda.readExcel.enums.EnumExceptions;
import com.ojeda.readExcel.exceptions.APIException;
import com.ojeda.readExcel.model.GenericResponse;
import com.ojeda.readExcel.services.GestionUsuariosServices;

@Service
public class GestionUsuariosServicesImpl implements GestionUsuariosServices {
    public GenericResponse<UsuariosDTO> registroMasivo(MultipartFile file) { 
        List<UsuarioDTO> listUsuarios= new ArrayList<>();
        try{
            if(!file.isEmpty()){
                String nameFile = file.getOriginalFilename();
                String[] extension = nameFile.split("\\.");
                if(validarExtension(Constantes.EXTENSION_DOC , extension[1])){
                    InputStream inputStream = file.getInputStream();
                    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
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
                    return new GenericResponse<UsuariosDTO>(Constantes.MENSAJE_EXITO, usuarios);
                }else{
                    List<String> detalles = Collections.singletonList("La extensión del documento no es la correcta");
                    throw new APIException(detalles, EnumExceptions.E400);
                }
            }else{
                List<String> detalles = Collections.singletonList("No se ha recibido un documento");
                throw new APIException(detalles, EnumExceptions.E400);
            }
        }catch (APIException e){
			throw e;
		}catch(Exception e){
            List<String> detalles = Collections.singletonList(e.getMessage());
            throw new APIException(detalles, EnumExceptions.E500);
        }
    }

    private static boolean validarExtension(String[] extensiones, String extension) {
        for (int i = 0; i < extensiones.length; i++) {
            if (extensiones[i].equals(extension)) {
                return true;
            }
        }
        return false;
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
