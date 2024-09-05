package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    
    @Query("SELECT m FROM Mascota m WHERE LOWER(m.estado) <> 'eliminada'")
    List<Mascota> findAllActivas();
}


