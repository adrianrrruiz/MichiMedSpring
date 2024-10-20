package com.example.demo.servicio;

import java.util.List;
import java.util.Map;

import com.example.demo.entidad.Mascota;

public interface MascotaServiceInterface {

    public Mascota SearchById(Long id);

    public List<Mascota> SearchAll();

    public void deleteById(Long id);

    public void update(Mascota mascota);

    public void add(Mascota mascota);

    public Map<String, Long> contarMascotasPorEstado();

    public int obtenerCantidadMascotasTratadas();

}
