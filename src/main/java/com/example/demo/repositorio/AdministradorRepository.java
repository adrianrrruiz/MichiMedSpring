package com.example.demo.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
  Optional<Administrador> findByCedula(String cedula);
}
