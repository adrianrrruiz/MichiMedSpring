package com.example.demo.repositorio;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

        @Query(value = "SELECT TO_CHAR(fecha, 'MMMM yyyy', 'es') AS mes, " +
                        "COUNT(*) AS cantidad " +
                        "FROM TRATAMIENTO " +
                        "GROUP BY TO_CHAR(fecha, 'MMMM yyyy', 'es') " +
                        "ORDER BY MIN(fecha);", nativeQuery = true)
        List<Map<String, Object>> contarTratamientosPorMes();

        @Query(value = "SELECT v.NOMBRE AS veterinario_nombre, " +
                        "d.NOMBRE AS droga_nombre, " +
                        "COUNT(t.ID) AS total_unidades_vendidas " +
                        "FROM TRATAMIENTO t " +
                        "JOIN VETERINARIO v ON t.VETERINARIO_ID = v.ID " +
                        "JOIN DROGA d ON t.DROGA_ID = d.ID " +
                        "GROUP BY v.NOMBRE, d.NOMBRE " +
                        "ORDER BY total_unidades_vendidas DESC " +
                        "LIMIT 3", nativeQuery = true)
        List<Map<String, Object>> findTopVeterinariosByDroga();

        @Query(value = "SELECT t FROM Tratamiento t WHERE t.mascota.id = :mascotaId")
        List<Tratamiento> findHistorialMedicoByMascotaId(@Param("mascotaId") Long mascotaId);
}
