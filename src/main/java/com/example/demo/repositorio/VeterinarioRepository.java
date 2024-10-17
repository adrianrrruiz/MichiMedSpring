package com.example.demo.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entidad.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{
    Optional<Veterinario> findByCedula(String cedula);

    @Query(value = "SELECT COUNT(*) AS cantidad  FROM VETERINARIO", nativeQuery = true)
    Long obtenerCantidadVeterinarios();
}
