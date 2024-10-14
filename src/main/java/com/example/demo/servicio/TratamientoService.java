package com.example.demo.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Droga;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.DrogaRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.repositorio.VeterinarioRepository;

@Service
public class TratamientoService implements TratamientoServiceInterface {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private DrogaRepository drogaRepository;

    @Override
    public List<Tratamiento> generarTratamientos() {
        List<Tratamiento> tratamientos = new ArrayList<>();

        List<Mascota> mascotas = mascotaRepository.findAll();
        List<Veterinario> veterinarios = veterinarioRepository.findAll();

        for (int i = 0; i < 10; i++) {
            Mascota mascota = mascotas.get(i % mascotas.size()); // Selecciona una mascota de la lista
            Veterinario veterinario = veterinarios.get(i % veterinarios.size()); // Selecciona un veterinario de la
                                                                                 // lista

            Tratamiento tratamiento = new Tratamiento("2024-10-" + (i + 1), mascota, veterinario);

            // Crear algunas drogas y asignarlas al tratamiento
            List<Droga> drogas = List.of(
                    new Droga("Droga A", 50.0, 80.0, 100, 5),
                    new Droga("Droga B", 30.0, 60.0, 150, 10));

            // Asignar el tratamiento a cada droga
            drogas.forEach(droga -> droga.setTratamiento(tratamiento));

            tratamiento.setDrogas(drogas);
            tratamientoRepository.save(tratamiento);
            drogaRepository.saveAll(drogas); // Guardar las drogas en la base de datos
            tratamientos.add(tratamiento);
        }

        return tratamientos;
    }

    @Override
    public Tratamiento searchById(Long id) {
        return tratamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado con id: " + id));
    }

    @Override
    public List<Tratamiento> SearchAll() {
        return tratamientoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Tratamiento tratamiento = tratamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado con id: " + id));
        tratamientoRepository.delete(tratamiento);
    }

    @Override
    public void update(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void add(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }
}
