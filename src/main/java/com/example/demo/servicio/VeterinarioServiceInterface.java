package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Veterinario;

public interface VeterinarioServiceInterface {
    public List<Mascota> getMascotas(Long id);

    public Veterinario SearchById(Long id);

    public List<Veterinario> SearchAll();

    public void deleteById(Long id);

    public void update(Veterinario veterinario);

    public void add(Veterinario veterinario);

    public Veterinario findByCedula(String cedula);

}
