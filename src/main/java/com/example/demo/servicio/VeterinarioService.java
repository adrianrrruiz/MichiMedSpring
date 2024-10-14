package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.VeterinarioRepository;

@Service
public class VeterinarioService implements VeterinarioServiceInterface {

    @Autowired
    VeterinarioRepository repository;

    @Override
    public List<Mascota> getMascotas(Long id) {
        return repository.findById(id).get().getMascotas();
    }

    @Override
    public Veterinario SearchById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Veterinario> SearchAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Veterinario veterinario) {
        Veterinario existingVeterinario = findByCedula(veterinario.getCedula());
        if (existingVeterinario != null && !existingVeterinario.getId().equals(veterinario.getId())) {
            throw new IllegalArgumentException("Ya existe un veterinario con esta cédula");
        }
        repository.save(veterinario);
    }

    @Override
    public void add(Veterinario veterinario) {
        Veterinario existingVeterinario = findByCedula(veterinario.getCedula());
        if (existingVeterinario != null && !existingVeterinario.getId().equals(veterinario.getId())) {
            throw new IllegalArgumentException("Ya existe un veterinario con esta cédula");
        }
        repository.save(veterinario);
    }

    @Override
    public Veterinario findByCedula(String cedula) {
        return repository.findByCedula(cedula).orElse(null);
    }

}
