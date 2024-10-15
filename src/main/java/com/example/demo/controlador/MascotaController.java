package com.example.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Mascota;
import com.example.demo.servicio.ClienteServiceInterface;
import com.example.demo.servicio.MascotaServiceInterface;

import io.swagger.v3.oas.annotations.Operation;

// http://localhost:8090/mascotas
@RequestMapping("/mascotas")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    @Autowired
    MascotaServiceInterface mascotaService;

    @Autowired
    ClienteServiceInterface clienteService;

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

    @GetMapping("/cliente/{id}")
    public Cliente findClienteByMascotaId(@PathVariable("id") Long id) {
        return mascotaService.SearchById(id).getCliente();
    }

    // http://localhost:8090/mascotas/add/{idCliente}
    @PostMapping("/add/{idCliente}")
    @Operation(summary = "Añadir una mascota asociada a un cliente")
    public void addMascota(@RequestBody Mascota mascota, @PathVariable("idCliente") Long idCliente) {
        mascota.setCliente(clienteService.SearchById(idCliente));
        mascotaService.add(mascota);
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
