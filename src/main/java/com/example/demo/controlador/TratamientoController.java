package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Tratamiento;
import com.example.demo.servicio.TratamientoService;

@RestController
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    // Obtener todos los tratamientos
    @GetMapping("/Tratamientos")
    public List<Tratamiento> obtenerTratamientos() {
        return tratamientoService.searchAll();
    }

    // Crear 10 tratamientos y asignar relaciones
    @PostMapping("/Tratamientos")
    public List<Tratamiento> agregarTratamientos() {
        return tratamientoService.generarTratamientos();
    }
}
