package com.example.demo.controlador;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entidad.Droga;

@Controller
public class DrogaController {

    @GetMapping("/drogas")
    public String listarDrogas(Model model) {
        List<Droga> listaDrogas = new ArrayList<>();  // La tabla estará vacía inicialmente
        model.addAttribute("drogas", listaDrogas);
        return "clientes/drogas";  // Devuelve la vista inicial de la página
    }

    @PostMapping("/cargarMedicamentos")
    public String cargarMedicamentos(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("error", "Por favor, sube un archivo válido.");
            return "clientes/drogas";  // Muestra un error si no se sube ningún archivo
        }

        List<Droga> listaDrogas = new ArrayList<>();

        try (InputStream is = file.getInputStream();
             XSSFWorkbook workbook = new XSSFWorkbook(is)) {

            Sheet sheet = workbook.getSheetAt(0);  // Primera hoja del archivo

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;  // Saltamos la fila de encabezado
                }

                Droga droga = new Droga();
                droga.setNombre(row.getCell(0).getStringCellValue());
                droga.setPrecioCompra(row.getCell(1).getNumericCellValue());
                droga.setPrecioVenta(row.getCell(2).getNumericCellValue());
                droga.setUniDisp((int) row.getCell(3).getNumericCellValue());
                droga.setUniVend((int) row.getCell(4).getNumericCellValue());

                listaDrogas.add(droga);
            }

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al procesar el archivo. Asegúrate de que el formato sea correcto.");
            return "clientes/drogas";  // Muestra un error si ocurre una excepción
        }

        model.addAttribute("drogas", listaDrogas);
        return "clientes/drogas";  // Devuelve la vista actualizada con los medicamentos
    }

}