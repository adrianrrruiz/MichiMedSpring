package com.example.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Mascota;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.MascotaServiceInterface;

// http://localhost:8090/mascotas
@RequestMapping("/mascotas")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    String ruta = "mascotas/";
    @Autowired
    MascotaServiceInterface mascotaService;

    @Autowired
    ClienteService clienteService;

    // http://localhost:8090/mascotas
    @GetMapping("")
    public List<Mascota> Mascotas() {
        return mascotaService.SearchAll();
    }

    // http://localhost:8090/mascotas/{id}
    @GetMapping("/{id}")
    public Mascota InfoMascota(@PathVariable("id") Long id) {
        return mascotaService.SearchById(id);
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
    public void addMascota(@RequestBody Mascota mascota) {
        mascotaService.add(mascota);
    }

    // http://localhost:8090/mascotas/update/{id}
    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        model.addAttribute("clientes", clienteService.SearchAll());
        return ruta +"updateMascota";
    }

    // http://localhost:8090/mascotas/update/{id}
    @PutMapping("/update")
    public void updateMascota(@RequestBody Mascota mascota) {
        mascotaService.update(mascota);
    }

    // http://localhost:8090/mascotas/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
    }
}
