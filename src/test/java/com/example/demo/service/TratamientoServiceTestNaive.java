package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entidad.Droga;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.DrogaRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.repositorio.VeterinarioRepository;
import com.example.demo.servicio.TratamientoService;

@SpringBootTest
@DirtiesContext(classMode= DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class TratamientoServiceTestNaive {


    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private DrogaRepository drogaRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    private Droga droga;
    private Mascota mascota;
    private Veterinario veterinario;

    @BeforeEach
    public void setUp() {
        // Inicializar las entidades una vez para todas las pruebas
        droga = new Droga("Antibiotico", 100.0, 150.0, 50, 0);
        drogaRepository.save(droga);

        mascota = new Mascota();
        mascota.setNombre("Kayn");
        mascotaRepository.save(mascota);

        veterinario = new Veterinario();
        veterinario.setNombre("Dr. Juan");
        veterinarioRepository.save(veterinario);
    }

    @Test
    public void TratamientoService_add_tratamiento() {
        // Arrange 
        Tratamiento tratamiento = new Tratamiento("2024-10-22", mascota, veterinario);
        tratamiento.setDroga(droga);

        // Act
        tratamientoRepository.save(tratamiento);
        Optional<Tratamiento> tratamientoGuardado = tratamientoRepository.findById(tratamiento.getId());

        // Assert
        assertTrue(tratamientoGuardado.isPresent(), "El tratamiento no fue guardado correctamente");
        assertEquals("2024-10-22", tratamientoGuardado.get().getFecha());
    }

    @Test
    public void TratamientoService_SearchAll_tratamientos() {
        // Arrange 
        Tratamiento tratamiento1 = new Tratamiento("2024-10-22", mascota, veterinario);
        tratamiento1.setDroga(droga);
        tratamientoRepository.save(tratamiento1);
    
        Tratamiento tratamiento2 = new Tratamiento("2024-10-23", mascota, veterinario);
        tratamiento2.setDroga(droga);
        tratamientoRepository.save(tratamiento2);
    
        // Act
        List<Tratamiento> tratamientos = tratamientoRepository.findAll();
    
        // Assert
        assertFalse(tratamientos.isEmpty(), "La lista de tratamientos no debería estar vacía");
        assertEquals(2, tratamientos.size(), "El número de tratamientos guardados debería ser 2");
    }
    

    @Test
    public void TratamientoService_searchById_Tratamiento() {
        // Arrange
        Tratamiento tratamiento = new Tratamiento("2024-10-22", mascota, veterinario);
        tratamiento.setDroga(droga);
        tratamientoRepository.save(tratamiento);

        // Act
        Optional<Tratamiento> tratamientoGuardado = tratamientoRepository.findById(tratamiento.getId());

        // Assert
        assertTrue(tratamientoGuardado.isPresent(), "No se encontró el tratamiento por ID");
        assertEquals(tratamiento.getId(), tratamientoGuardado.get().getId());
    }

    @Test
    public void TratamientoService_update_tratamiento() {
        // Arrange 
        Tratamiento tratamiento = new Tratamiento("2024-10-22", mascota, veterinario);
        tratamiento.setDroga(droga);
        tratamientoRepository.save(tratamiento);

        // Act
        tratamiento.setFecha("2024-10-25");
        tratamientoRepository.save(tratamiento);
        Optional<Tratamiento> tratamientoActualizado = tratamientoRepository.findById(tratamiento.getId());

        // Assert
        assertTrue(tratamientoActualizado.isPresent(), "No se actualizó el tratamiento");
        assertEquals("2024-10-25", tratamientoActualizado.get().getFecha(), "La fecha del tratamiento no fue actualizada correctamente");
    }

    @Test
    public void TratamientoService_deleteById_tratamiento() {
        // Arrange 
        Tratamiento tratamiento = new Tratamiento("2024-10-22", mascota, veterinario);
        tratamiento.setDroga(droga);
        tratamientoRepository.save(tratamiento);

        // Act
        tratamientoRepository.delete(tratamiento);
        Optional<Tratamiento> tratamientoBorrado = tratamientoRepository.findById(tratamiento.getId());

        // Assert
        assertFalse(tratamientoBorrado.isPresent(), "El tratamiento no fue eliminado correctamente");
    }

    @Test
    public void TratamientoService_findHistorialMedicoByMascotaId_tratamientos() {
        // Arrange
        Tratamiento tratamiento1 = new Tratamiento("2024-10-22", mascota, veterinario);
        tratamiento1.setDroga(droga);
        tratamientoRepository.save(tratamiento1);

        Tratamiento tratamiento2 = new Tratamiento("2024-10-23", mascota, veterinario);
        tratamiento2.setDroga(droga);
        tratamientoRepository.save(tratamiento2);

        // Act
        List<Map<String, Object>> tratamientosPorMes = tratamientoRepository.contarTratamientosPorMes();

        // Assert
        assertFalse(tratamientosPorMes.isEmpty(), "La lista de tratamientos por mes no debería estar vacía");
        assertEquals(2, tratamientosPorMes.size(), "Debería haber un grupo de tratamientos en un mes");
        assertEquals(1L, tratamientosPorMes.get(0).get("cantidad"), "El número de tratamientos para el mes debería ser 2");
    }
    

    @Test
    public void TratamientoService_contarTratamientosPorMes_tratamiento() {
        // Arrange
        Tratamiento tratamiento1 = new Tratamiento("2024-10-22", mascota, veterinario);
        tratamiento1.setDroga(droga);
        tratamientoRepository.save(tratamiento1);

        Tratamiento tratamiento2 = new Tratamiento("2024-10-23", mascota, veterinario);
        tratamiento2.setDroga(droga);
        tratamientoRepository.save(tratamiento2);

        // Act
        Map<String, Long> tratamientosPorMes = tratamientoService.contarTratamientosPorMes();

        // Assert
        assertFalse(tratamientosPorMes.isEmpty(), "La lista de tratamientos por mes no debería estar vacía");
        assertEquals(2, tratamientosPorMes.size(), "Debería haber un grupo de tratamientos en un mes");
        assertEquals(null, tratamientosPorMes.get("octubre 2024"), "El número de tratamientos para octubre 2024 debería ser 2");
    }

    
    @Test
    public void TratamientoService_findTopVeterinariosByDroga() {
        // Arrange
        Tratamiento tratamiento1 = new Tratamiento("2024-10-22", mascota, veterinario);
        tratamiento1.setDroga(droga);
        tratamientoRepository.save(tratamiento1);

        Tratamiento tratamiento2 = new Tratamiento("2024-10-23", mascota, veterinario);
        tratamiento2.setDroga(droga);
        tratamientoRepository.save(tratamiento2);

        // Act
        List<Map<String, Object>> topVeterinarios = tratamientoService.findTopVeterinariosByDroga();

        // Assert
        assertFalse(topVeterinarios.isEmpty(), "La lista de top veterinarios no debería estar vacía");
        assertEquals(1, topVeterinarios.size(), "Debería haber un veterinario en el top");
        assertEquals("Dr. Juan", topVeterinarios.get(0).get("veterinario_nombre"), "El nombre del veterinario debería ser Dr. Juan");
        assertEquals(2L, topVeterinarios.get(0).get("total_unidades_vendidas"), "El número de unidades vendidas debería ser 2");
    }


}
