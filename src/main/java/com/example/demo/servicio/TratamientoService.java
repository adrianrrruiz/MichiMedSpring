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

import com.example.demo.entidad.HistorialMedicoDTO;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.repositorio.TratamientoRepository;

@Service
public class TratamientoService implements TratamientoServiceInterface {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    private static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("dd/MM/yy")
            .parseDefaulting(ChronoField.ERA, 1)
            .parseDefaulting(ChronoField.YEAR_OF_ERA, 2000)
            .toFormatter()
            .withResolverStyle(ResolverStyle.STRICT);

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
        List<Tratamiento> tratamientos = tratamientoRepository.findAll();

        Map<String, Long> tratamientosPorMes = tratamientos.stream()
                .collect(Collectors.groupingBy(
                        tratamiento -> {
                            LocalDate fecha = LocalDate.parse(tratamiento.getFecha(), DATE_FORMATTER);
                            return fecha.getMonth().getDisplayName(TextStyle.FULL, new Locale("es"));
                        },
                        Collectors.counting()));

        // Ordenar el mapa por el mes
        return tratamientosPorMes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(this::mesAEntero)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
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
                tratamientos
                        .add(new HistorialMedicoDTO(tratamiento.getFecha(),
                                tratamiento.getVeterinario().getNombre(),
                                tratamiento.getVeterinario().getUrlFoto(), tratamiento.getDroga().getNombre()));
            }
        }
        return tratamientos;
    }
}
