package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Droga;
import com.example.demo.servicio.DrogaServiceInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/drogas")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DrogaController {

    @Autowired
    DrogaServiceInterface drogaService;

    // http://localhost:8090/drogas
    @GetMapping("")
    public List<Droga> getAllDrogas() {
        return drogaService.SearchAll();
    }

    @PostMapping("/add")
    public void addDrogas(@RequestBody Droga[] drogas) {
        drogaService.add(drogas);
    }

}