package com.example.demo.controlador;

import java.util.List;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Veterinario;
import java.util.Map;

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

import com.example.demo.servicio.VeterinarioServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/veterinarios")

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class VeterinarioController {

    @Autowired
    VeterinarioServiceInterface veterinarioService;

    // localhost:8090/veterinarios
    @GetMapping("")
    public List<Veterinario> getAllVeterinarios() {
        return veterinarioService.SearchAll();
    }

    // localhost:8090/veterinarios/{id}
    @GetMapping("{id}")
    public Veterinario getVeterinarioById(@PathVariable("id") Long id) {
        return veterinarioService.SearchById(id);
    }

    // localhost:8090/veterinarios/mascotas/{id}
    @GetMapping("mascotas/{id}")
    @Operation(summary = "Obtener las mascotas de un veterinario")
    public List<Mascota> getMascotasVeterinario(@PathVariable("id") Long id) {
        return veterinarioService.getMascotas(id);
    }

    // localhost:8090/veterinarios/estadisticas
    @GetMapping("estadisticas")
    public Map<String, Long> obtenerEstadisticasVeterinarios() {
        return veterinarioService.obtenerEstadisticasVeterinarios();
    }

    // localhost:8090/veterinarios/add
    @PostMapping("/add")
    public void addVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
    }

    // localhost:8090/veterinarios/update
    @PutMapping("/update")
    public void updateVeterinario(@RequestBody Veterinario veterinario) {
        List<Mascota> mascotas = veterinarioService.SearchById(veterinario.getId()).getMascotas();
        veterinario.setMascotas(mascotas);
        veterinarioService.update(veterinario);
    }

    // localhost:8090/veterinarios/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteVeterinario(@PathVariable("id") Long id) {
        veterinarioService.deleteById(id);
    }

}
