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
}
