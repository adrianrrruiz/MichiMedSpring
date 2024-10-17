package com.example.demo.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entidad.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{
    Optional<Veterinario> findByCedula(String cedula);

    @Query(value = "SELECT (SELECT COUNT(*) FROM VETERINARIO) AS total_veterinarios, COUNT(DISTINCT v.ID) AS veterinarios_activos FROM VETERINARIO v LEFT JOIN TRATAMIENTO t ON v.ID = t.VETERINARIO_ID WHERE t.VETERINARIO_id IS NOT NULL", nativeQuery = true)
    Map<String, Long> obtenerEstadisticasVeterinarios();
}
