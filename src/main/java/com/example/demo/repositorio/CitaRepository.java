package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entidad.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    @Query("SELECT COUNT(c) FROM Cita c WHERE c.fecha = :fecha")
    long countByFecha(@Param("fecha") String fecha);

    List<Cita> findByFecha(String fecha);
}