package com.example.demo.repositorio;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    
    @Query("SELECT m FROM Mascota m WHERE LOWER(m.estado) <> 'eliminada'")
    List<Mascota> findAllActivas();

    @Query(value = "SELECT estado, COUNT(*) AS cantidad FROM MASCOTA WHERE estado IN ('En tratamiento', 'Tratado') GROUP BY estado;", nativeQuery = true)
    List<Map<String, Object>> contarMascotasPorEstado();
}



