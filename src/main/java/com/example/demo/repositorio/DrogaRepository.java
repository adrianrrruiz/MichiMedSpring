package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidad.Droga;

public interface DrogaRepository extends JpaRepository<Droga, Long> {}
