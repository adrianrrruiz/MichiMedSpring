package com.example.demo.servicio;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Mascota;
import com.example.demo.repositorio.MascotaRepository;

@Service
public class MascotaService implements MascotaServiceInterface {

    @Autowired
    MascotaRepository repository;

    @Override
    public Mascota SearchById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
    }

    @Override
    public List<Mascota> SearchAll() {
        List<Mascota> todasLasMascotas = repository.findAll();
        // Filtrar mascotas eliminadas antes de devolverlas
        List<Mascota> mascotasActivas = todasLasMascotas.stream()
                .filter(mascota -> !"Eliminada".equalsIgnoreCase(mascota.getEstado()))
                .collect(Collectors.toList());

        return mascotasActivas;
    }

    @Override
    public void deleteById(Long id) {
        Mascota mascota = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
        mascota.setEstado("Eliminada");
        repository.save(mascota);
    }

    @Override
    public void update(Mascota mascota) {
        repository.save(mascota);
    }

    @Override
    public void add(Mascota mascota) {
        repository.save(mascota);
    }

    public Map<String, Long> contarMascotasPorEstado() {
        List<Map<String, Object>> resultados = repository.contarMascotasPorEstado();

        return resultados.stream()
                .collect(Collectors.toMap(
                        resultado -> (String) resultado.get("estado"),
                        resultado -> ((Number) resultado.get("cantidad")).longValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    @Override
    public int obtenerCantidadMascotasTratadas() {
        List<Mascota> todasLasMascotas = repository.findAll();
        return (int) todasLasMascotas.stream()
                .filter(mascota -> "Tratado".equalsIgnoreCase(mascota.getEstado()))
                .count();
    }
}
