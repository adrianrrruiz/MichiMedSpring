package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Tratamiento;
import com.example.demo.servicio.TratamientoServiceInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/tratamientos")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {

    @Autowired
    private TratamientoServiceInterface tratamientoService;

    // localhost:8090/tratamientos
    @GetMapping("")
    public List<Tratamiento> getAllTratamientos() {
        return tratamientoService.SearchAll();
    }

    @PostMapping("/add")
    public void addTratamiento(@RequestBody Tratamiento tratamiento) {
        tratamientoService.add(tratamiento);
    }

}
