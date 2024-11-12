package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entidad.Cita;
import com.example.demo.servicio.CitaService;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @PostMapping("/asignar")
    public ResponseEntity<Cita> asignarCita(@RequestBody Cita cita) {
        try {
            Cita nuevaCita = citaService.asignarCita(cita);
            return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Cita>> obtenerCitasPorFecha(@PathVariable String fecha) {
        List<Cita> citas = citaService.obtenerCitasPorFecha(fecha);
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
}