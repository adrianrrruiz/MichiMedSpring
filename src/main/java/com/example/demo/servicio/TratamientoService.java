package com.example.demo.servicio;

import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Locale;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Droga;
import com.example.demo.entidad.HistorialMedicoDTO;
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

    private static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("dd/MM/yy")
            .parseDefaulting(ChronoField.ERA, 1)
            .parseDefaulting(ChronoField.YEAR_OF_ERA, 2000)
            .toFormatter()
            .withResolverStyle(ResolverStyle.STRICT);

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
    public Map<String, Long> contarTratamientosPorMes() {
        List<Map<String, Object>> resultados = tratamientoRepository.contarTratamientosPorMes();

        return resultados.stream()
                .collect(Collectors.toMap(
                        resultado -> (String) resultado.get("mes"),
                        resultado -> ((Number) resultado.get("cantidad")).longValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private int mesAEntero(String mes) {
        switch (mes.toLowerCase()) {
            case "enero":
                return 1;
            case "febrero":
                return 2;
            case "marzo":
                return 3;
            case "abril":
                return 4;
            case "mayo":
                return 5;
            case "junio":
                return 6;
            case "julio":
                return 7;
            case "agosto":
                return 8;
            case "septiembre":
                return 9;
            case "octubre":
                return 10;
            case "noviembre":
                return 11;
            case "diciembre":
                return 12;
            default:
                throw new IllegalArgumentException("Mes desconocido: " + mes);
        }
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

    @Override
    public List<HistorialMedicoDTO> findHistorialMedicoByMascotaId(Long id) {
        List<HistorialMedicoDTO> tratamientos = new ArrayList<>();
        for (Tratamiento tratamiento : SearchAll()) {
            if (tratamiento.getMascota().getId() == id) {
                // Obtener la lista de nombres de drogas
                List<String> nombresDrogas = tratamiento.getDrogas().stream()
                        .map(Droga::getNombre) // Convertir las drogas a sus nombres
                        .collect(Collectors.toList());
                tratamientos
                        .add(new HistorialMedicoDTO(tratamiento.getFecha(), tratamiento.getVeterinario().getNombre(),
                                tratamiento.getVeterinario().getUrlFoto(), nombresDrogas));
            }
        }
        return tratamientos;
    }
}
