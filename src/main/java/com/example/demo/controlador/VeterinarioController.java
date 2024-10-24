package com.example.demo.controlador;

import java.net.http.HttpResponse;
import java.util.List;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Veterinario;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Veterinario>> getAllVeterinarios() {

        List<Veterinario> lista = veterinarioService.SearchAll();
        ResponseEntity<List<Veterinario>> response = new ResponseEntity<>(lista, HttpStatus.OK);
        return response;

    }

    // localhost:8090/veterinarios/{id}
    @GetMapping("{id}")
    public ResponseEntity<Veterinario> getVeterinarioById(@PathVariable("id") Long id) {
        Veterinario veterinario = veterinarioService.SearchById(id);
        if (veterinario == null) {
            return new ResponseEntity<Veterinario>(HttpStatus.NOT_FOUND);
        }
        ResponseEntity<Veterinario> response = new ResponseEntity<>(veterinario, HttpStatus.OK);
        return response;
    }

    // localhost:8090/veterinarios/add
    @PostMapping("/add")
    public ResponseEntity<Veterinario> addVeterinario(@RequestBody Veterinario veterinario) {
        try {
            Veterinario savedVeterinario = veterinarioService.add(veterinario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                    .body(savedVeterinario);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Veterinario> updateVeterinario(@RequestBody Veterinario veterinario) {
        try {
            veterinarioService.update(veterinario);
            return new ResponseEntity<Veterinario>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Veterinario>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Veterinario> deleteVeterinario(@PathVariable("id") Long id) {
        try {
            veterinarioService.deleteById(id);
            return new ResponseEntity<Veterinario>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Veterinario>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/estadisticas")
    public ResponseEntity<Map<String, Long>> obtenerEstadisticasVeterinarios() {
        Map<String, Long> estadisticas = veterinarioService.obtenerEstadisticasVeterinarios();
        if (estadisticas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
    }

    @GetMapping("mascotas/{id}")
    @Operation(summary = "Obtener las mascotas de un veterinario")
    public List<Mascota> getMascotasVeterinario(@PathVariable("id") Long id) {
        return veterinarioService.getMascotas(id);
    }

}
