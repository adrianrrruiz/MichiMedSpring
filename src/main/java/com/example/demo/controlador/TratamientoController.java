package com.example.demo.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.HistorialMedicoDTO;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.entidad.TratamientoDTO;
import com.example.demo.servicio.DrogaServiceInterface;
import com.example.demo.servicio.TratamientoServiceInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/tratamientos")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {

    @Autowired
    private TratamientoServiceInterface tratamientoService;

    @Autowired
    private DrogaServiceInterface drogaService;

    // localhost:8090/tratamientos
    @GetMapping("")
    public List<Tratamiento> getAllTratamientos() {
        return tratamientoService.SearchAll();
    }

    @GetMapping("/tratamientos-por-mes")
    public Map<String, Long> obtenerTratamientosPorMes() {
        return tratamientoService.contarTratamientosPorMes();
    }

    @PostMapping("/add")
    public void addTratamiento(@RequestBody TratamientoDTO tratamientoDTO) {

        Tratamiento tratamiento = new Tratamiento(tratamientoDTO.getFecha());
        tratamiento.setMascota(tratamientoDTO.getMascota());
        tratamiento.setVeterinario(tratamientoDTO.getVeterinario());
        tratamiento.setDroga(tratamientoDTO.getDroga());

        drogaService.update(tratamientoDTO.getDroga());

        tratamientoService.add(tratamiento);
    }

    @GetMapping("/historial-medico/{id}")
    public List<HistorialMedicoDTO> findHistorialMedicoByMascotaId(@PathVariable("id") Long id) {
        return tratamientoService.findHistorialMedicoByMascotaId(id);
    }

}
