package com.example.demo.repositorio;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
    @Query(value = "SELECT FORMATDATETIME(PARSEDATETIME(fecha, 'dd/MM/yy'), 'MMMM yyyy', 'es') AS mes, COUNT(*) AS cantidad FROM TRATAMIENTO GROUP BY FORMATDATETIME(PARSEDATETIME(fecha, 'dd/MM/yy'), 'MMMM yyyy', 'es') ORDER BY MIN(PARSEDATETIME(fecha, 'dd/MM/yy'));", nativeQuery = true)
    List<Map<String, Object>> contarTratamientosPorMes();

    @Query(value = "SELECT v.NOMBRE AS veterinario_nombre,  d.NOMBRE AS droga_nombre,  SUM(d.UNI_VEND) AS total_unidades_vendidas FROM TRATAMIENTO t JOIN VETERINARIO v ON t.VETERINARIO_ID = v.ID JOIN DROGA d ON t.DROGA_ID = d.ID GROUP BY t.ID, v.NOMBRE, d.NOMBRE ORDER BY total_unidades_vendidas DESC LIMIT 3;\n" + //
                "", nativeQuery = true)
    List<Map<String, Object>> findTopVeterinariosByDroga();
}
