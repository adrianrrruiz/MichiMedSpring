package com.example.demo.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Mascota;
import com.example.demo.repositorio.MascotaRepository;

@Service
public class MascotaService implements MascotaServiceInterface {
    
    @Autowired
    MascotaRepository repo;

    @Override
    public Mascota SearchById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
    }

    @Override
    public List<Mascota> SearchAll() {
        List<Mascota> todasLasMascotas = repo.findAll();
        // Filtrar mascotas eliminadas antes de devolverlas
        List<Mascota> mascotasActivas = todasLasMascotas.stream()
            .filter(mascota -> !"Eliminada".equalsIgnoreCase(mascota.getEstado()))
            .collect(Collectors.toList());

        return mascotasActivas;
    }

    @Override
    public void deleteById(Long id) {
        Mascota mascota = repo.findById(id).orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
        mascota.setEstado("Eliminada");
        repo.save(mascota);
    }

    @Override
    public void update(Mascota mascota) {
        repo.save(mascota);
    }

    @Override
    public void add(Mascota mascota) {
        repo.save(mascota);
    }
}
