package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cita;
import com.example.demo.repositorio.CitaRepository;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;

    public Cita asignarCita(Cita cita) {
        long count = citaRepository.countByFecha(cita.getFecha());
        if (count >= 5) {
            throw new IllegalArgumentException("No se pueden aceptar más de 5 citas por día");
        }
        return citaRepository.save(cita);
    }

    public List<Cita> obtenerCitasPorFecha(String fecha) {
        return citaRepository.findByFecha(fecha);
    }
}