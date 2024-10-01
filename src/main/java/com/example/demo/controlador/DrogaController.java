package com.example.demo.controlador;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.servicio.DrogaService;

@RestController
public class DrogaController {

    @Autowired
    private DrogaService drogaService;

    @PostMapping("/cargarMedicamentos")
    public String cargarMedicamentos() {
        try {
            drogaService.cargarMedicamentosDesdeArchivo();  // Sin parámetro
            return "Medicamentos cargados exitosamente desde el archivo.";
        } catch (IOException e) {
            return "Error al cargar el archivo de medicamentos: " + e.getMessage();
        }
    }
}

