package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.User;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.VeterinarioRepository;

@Service
public class VeterinarioService implements VeterinarioServiceInterface {

    @Autowired
    VeterinarioRepository repository;

    @Override
    public Long verifyCredentials(User user) {
        Optional<Veterinario> veterinario = repository.findByCedula(user.getCedula());

        if (veterinario.isPresent()) {
            String veterinarioContrasena = veterinario.get().getContrasena();
            String userPassword = user.getPassword();

            // Verificar que ambas contraseñas no sean null antes de la comparación
            if (veterinarioContrasena != null && veterinarioContrasena.equals(userPassword)) {
                return veterinario.get().getId();
            }
        }

        return -1L;
    }

    @Override
    public List<Mascota> getMascotas(Long id) {
        return repository.findById(id).get().getMascotas();
    }

    @Override
    public Map<String, Long> obtenerEstadisticasVeterinarios() {
        return repository.obtenerEstadisticasVeterinarios();
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
    public Veterinario deleteById(Long id) {
        Optional<Veterinario> veterinario = repository.findById(id);
        if (veterinario.isPresent()) {
            repository.deleteById(id);
            return veterinario.get();
        } else {
            throw new IllegalArgumentException("Veterinario not found with id: " + id);
        }
    }

    @Override
    public Veterinario update(Veterinario veterinario) {
        Veterinario existingVeterinario = findByCedula(veterinario.getCedula());
        if (existingVeterinario != null && !existingVeterinario.getId().equals(veterinario.getId())) {
            throw new IllegalArgumentException("Ya existe un veterinario con esta cédula");
        }
        repository.save(veterinario);
        return existingVeterinario;
    }

    @Override
    public Veterinario add(Veterinario veterinario) {
        Veterinario existingVeterinario = findByCedula(veterinario.getCedula());
        if (existingVeterinario != null && !existingVeterinario.getId().equals(veterinario.getId())) {
            throw new IllegalArgumentException("Ya existe un veterinario con esta cédula");
        }
        repository.save(veterinario);
        return existingVeterinario;
    }

    @Override
    public Veterinario findByCedula(String cedula) {
        return repository.findByCedula(cedula).orElse(null);
    }

}
