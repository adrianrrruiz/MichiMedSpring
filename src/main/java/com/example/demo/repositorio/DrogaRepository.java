package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Droga;

@Repository
public interface DrogaRepository extends JpaRepository<Droga, Long> {
}
