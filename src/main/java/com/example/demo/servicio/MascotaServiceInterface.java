package com.example.demo.servicio;

import java.util.List;
import java.util.Map;

import com.example.demo.entidad.Mascota;

public interface MascotaServiceInterface {

    Mascota SearchById(Long id);

    List<Mascota> SearchAll();

    void deleteById(Long id);

    void update(Mascota mascota);

    void add(Mascota mascota);

    Map<String, Long> contarMascotasPorEstado();

    int obtenerCantidadMascotasTratadas();

    void iniciarAdopcion(Long id);

    void confirmarAdopcion(Long id);

    List<Mascota> obtenerMascotasPendientesAdopcion();
}
