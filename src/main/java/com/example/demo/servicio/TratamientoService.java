package com.example.demo.servicio;

import java.time.temporal.ChronoField;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOs.HistorialMedicoDTO;
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
        List<Map<String, Object>> resultados = tratamientoRepository.contarTratamientosPorMes();

        return resultados.stream()
                .collect(Collectors.toMap(
                        resultado -> (String) resultado.get("mes"),
                        resultado -> ((Number) resultado.get("cantidad")).longValue(),
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
    public Tratamiento update(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    @Override
    public Tratamiento add(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    @Override
    public List<HistorialMedicoDTO> findHistorialMedicoByMascotaId(Long id) {
        List<Tratamiento> tratamientos = tratamientoRepository.findHistorialMedicoByMascotaId(id);
        List<HistorialMedicoDTO> historialMedico = new ArrayList<>();
        for (Tratamiento t : tratamientos) {
            historialMedico.add(new HistorialMedicoDTO(t.getFecha(), t.getVeterinario().getNombre(),
                    t.getVeterinario().getUrlFoto(), t.getDroga().getNombre()));
        }
        return historialMedico;
    }

    @Override
    public List<Map<String, Object>> findTopVeterinariosByDroga() {
        return tratamientoRepository.findTopVeterinariosByDroga();
    }
}
