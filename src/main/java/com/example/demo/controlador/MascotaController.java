package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.servicio.MascotaServiceInterface;


// http://localhost:8090/mascotas
@RequestMapping("/mascotas")
@Controller
public class MascotaController {
    
    @Autowired
    MascotaServiceInterface mascotaService;

    // http://localhost:8090/mascotas
    @GetMapping("")
    public String Mascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return "mascotas";
    }

    // http://localhost:8090/mascotas/{id}
    @GetMapping("/{id}")
    public String InfoMascota(Model model, @PathVariable("id")int id){
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "infoMascota";
    }
}
