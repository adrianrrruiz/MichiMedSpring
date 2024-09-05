package com.example.demo.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Mascota;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaServiceInterface;

// http://localhost:8090/mascotas
@RequestMapping("/mascotas")
@Controller
public class MascotaController {

    String ruta = "mascotas/";
    @Autowired
    MascotaServiceInterface mascotaService;

    @Autowired
    ClienteService clienteService;

    // http://localhost:8090/mascotas
    @GetMapping("")
    public String Mascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return ruta +"mascotas";
    }

    // http://localhost:8090/mascotas/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Mascota mascota = new Mascota( null, 0, null, 0, null, null, null, null, null, null);
        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.SearchAll());
        return ruta +"mascotasAdd";
    }

    // http://localhost:8090/mascotas/add
    @PostMapping("/add")
    public String addMascota(@ModelAttribute("mascota") Mascota mascota) {
        mascotaService.add(mascota);
        return "redirect:/mascotas";
    }

    // http://localhost:8090/mascotas/update/{id}
    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        model.addAttribute("clientes", clienteService.SearchAll());
        return ruta +"updateMascota";
    }

    // http://localhost:8090/mascotas/update/{id}
    @PostMapping("/update/{id}")
    public String updateMascota(@PathVariable("id") Long id, @ModelAttribute Mascota mascota) {
        mascotaService.update(mascota);
        return "redirect:/mascotas";
    }

    // http://localhost:8090/mascotas/delete/{id}
    @GetMapping("/delete/{id}")
    public String deleteMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
        return "redirect:/mascotas";
    }
    
    // http://localhost:8090/mascotas/{id}
    @GetMapping("/{id}")
public String InfoMascota(Model model, @PathVariable("id") Long id) {
    Mascota mascota = mascotaService.SearchById(id);
    Cliente cliente = mascota.getCliente(); // Obtener el cliente asociado a la mascota
    model.addAttribute("mascota", mascota);
    model.addAttribute("cliente", cliente); // Añadir el cliente al modelo
    return ruta + "infoMascota";
}
}
