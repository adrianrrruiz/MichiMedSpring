package com.example.demo.controlador;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Veterinario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.servicio.VeterinarioService;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/veterinarios")

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class VeterinarioController {
    String ruta = "veterinarios/";

    @Autowired 
    VeterinarioService Service;

    // localhost:8090/veterinarios
    @GetMapping("")
    public List<Veterinario> getAllVeterinarios(){
        return Service.SearchAll();
    }

    // localhost:8090/veterinarios/mascotas/{id}
    @GetMapping("mascotas/{id}")
    public List<Mascota> getMascotasVeterinario(@PathVariable("id") Long id){
        return Service.getMascotas(id);
    }

    // localhost:8090/veterinarios/{id}
    @GetMapping("{id}")
    public Veterinario getVeterinarioById(@PathVariable("id") Long id){
        return Service.SearchById(id);
    }

    // localhost:8090/veterinarios/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model){
        Veterinario veterinario = new Veterinario();
        model.addAttribute("veterinario", veterinario);
        return ruta + "veterinariosAdd";
    }

    // localhost:8090/veterinarios/add
    @PostMapping("/add")
    public String addVeterinario(@ModelAttribute("veterinario") Veterinario veterinario, Model model){
        try{
            Service.add(veterinario);
            return "redirect:/" + ruta;
        } catch (DataIntegrityViolationException e){
            model.addAttribute("error", "Ya existe un veterinario con esta cédula");
            return ruta + "veterinariosAdd";
        }
    }

    // localhost:8090/veterinarios/update
    @PutMapping("/update")
    public void updateVeterinario(@RequestBody Veterinario veterinario){
        Service.update(veterinario);
    }

    // localhost:8090/veterinarios/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteVeterinario(@PathVariable("id") Long id){
        Service.deleteById(id);
    }
    
}
