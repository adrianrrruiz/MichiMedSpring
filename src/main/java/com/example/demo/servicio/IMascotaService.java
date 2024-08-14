package com.example.demo.servicio;

import java.util.Collection;

import com.example.demo.entidad.Mascota;

public interface IMascotaService {
    public Mascota findById(int id);
    public Collection<Mascota> findAll();
}
