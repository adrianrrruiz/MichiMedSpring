package com.example.demo.servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Droga;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.repositorio.DrogaRepository;
import com.example.demo.repositorio.TratamientoRepository;

@Service
public class DrogaService {

    private DrogaRepository drogaRepository;

    private TratamientoRepository tratamientoRepository;

    public void cargarMedicamentosDesdeArchivo() throws IOException {
        // Ruta fija del archivo dentro de tu proyecto
        Resource resource = new ClassPathResource("static/assets/files/MEDICAMENTOS_VETERINARIA.xlsx");
        File file = resource.getFile();

        // Leer el archivo de medicamentos usando FileInputStream
        try (FileInputStream fileInputStream = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {

            XSSFSheet sheet = workbook.getSheetAt(0); // Primera hoja del archivo
            Iterator<Row> rowIterator = sheet.iterator();
            List<Droga> listaDrogas = new ArrayList<>();

            // Saltar la primera fila (encabezado)
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Droga droga = new Droga();

                // Leer cada celda de la fila y mapear a los atributos de Droga
                droga.setNombre(row.getCell(0).getStringCellValue());
                droga.setPrecioCompra(row.getCell(1).getNumericCellValue());
                droga.setPrecioVenta(row.getCell(2).getNumericCellValue());
                droga.setUniDisp((int) row.getCell(3).getNumericCellValue());
                droga.setUniVend((int) row.getCell(4).getNumericCellValue());

                // Asignar un tratamiento a la droga (opcional)
                Long tratamientoId = (long) row.getCell(5).getNumericCellValue(); // ID del tratamiento en la columna 6
                Tratamiento tratamiento = tratamientoRepository.findById(tratamientoId)
                    .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado con id: " + tratamientoId));
                droga.setTratamiento(tratamiento);

                listaDrogas.add(droga);
            }

            // Guardar todos los medicamentos (drogas) en la base de datos
            drogaRepository.saveAll(listaDrogas);

        } catch (IOException e) {
            throw new IOException("Error al leer el archivo: " + e.getMessage(), e);
        }
    }
}
