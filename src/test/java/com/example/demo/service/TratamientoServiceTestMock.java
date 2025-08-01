package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.DTOs.HistorialMedicoDTO;
import com.example.demo.entidad.Droga;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.servicio.TratamientoService;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TratamientoServiceTestMock {

  @InjectMocks
  private TratamientoService tratamientoService;

  @Mock
  TratamientoRepository tratamientoRepository;

  @BeforeEach
  public void init() {

  }

  @Test
  public void TratamientoService_add_Tratamiento() {
    Tratamiento tratamiento = new Tratamiento("22/10/2024");

    when(tratamientoRepository.save(tratamiento)).thenReturn(
        tratamiento);

    Tratamiento newTratamiento = tratamientoService.add(tratamiento);

    Assertions.assertThat(newTratamiento).isNotNull();
  }

  @Test
  public void TratamientoService_SearchAll_TratamientoList() {

    when(tratamientoRepository.findAll()).thenReturn(
        List.of(
            new Tratamiento("22/10/2024"),
            new Tratamiento("23/10/2024")));

    List<Tratamiento> tratamientos = tratamientoService.SearchAll();

    Assertions.assertThat(tratamientos).isNotNull();
    Assertions.assertThat(tratamientos.size()).isEqualTo(2);
  }

  @Test
  public void TratamientoService_searchById_Tratamiento() {
    when(tratamientoRepository.findById(1L)).thenReturn(
        Optional.of(new Tratamiento("22/10/2024")));

    Tratamiento tratamiento = tratamientoService.searchById(1L);

    Assertions.assertThat(tratamiento).isNotNull();
  }

  @Test
  public void TratamientoService_update_Tratamiento() {
    Tratamiento tratamiento = new Tratamiento("22/10/2024");

    when(tratamientoRepository.save(tratamiento)).thenReturn(
        tratamiento);

    Tratamiento updatedTratamiento = tratamientoService.update(tratamiento);

    Assertions.assertThat(updatedTratamiento).isNotNull();
  }

  @Test
  public void TratamientoService_deleteById_EmptyTratamiento() {
    Tratamiento tratamiento = new Tratamiento("22/10/2024");

    when(tratamientoRepository.findById(1L)).thenReturn(
        Optional.of(tratamiento));

    tratamientoService.deleteById(1L);

    when(tratamientoRepository.findById(1L)).thenReturn(Optional.empty());
    Optional<Tratamiento> tratamientoBorrado = tratamientoRepository.findById(1L);

    Assertions.assertThat(tratamientoBorrado).isEmpty();
  }

  @Test
  public void TratamientoService_findHistorialMedicoByMascotaId_HistorialMedicoDTOList() {
    Mascota mascota = new Mascota();
    mascota.setId(1L);

    Veterinario veterinario = new Veterinario();
    veterinario.setNombre("Dr. Juan");
    veterinario.setUrlFoto("urlFotoVeterinario");

    Droga droga = new Droga();
    droga.setNombre("Antibiotico");

    Tratamiento tratamiento1 = new Tratamiento();
    tratamiento1.setFecha("22/10/2024");
    tratamiento1.setVeterinario(veterinario);
    tratamiento1.setDroga(droga);
    tratamiento1.setMascota(mascota);

    Tratamiento tratamiento2 = new Tratamiento();
    tratamiento2.setFecha("23/10/2024");
    tratamiento2.setVeterinario(veterinario);
    tratamiento2.setDroga(droga);
    tratamiento2.setMascota(mascota);

    // Mock del repositorio para devolver los tratamientos
    List<Tratamiento> mockTratamientos = List.of(tratamiento1, tratamiento2);
    when(tratamientoRepository.findHistorialMedicoByMascotaId(1L)).thenReturn(mockTratamientos);

    // Llamada al método del servicio
    List<HistorialMedicoDTO> result = tratamientoService.findHistorialMedicoByMascotaId(1L);

    // Verificaciones
    Assertions.assertThat(result).isNotNull();
    Assertions.assertThat(result.size()).isEqualTo(2);
    Assertions.assertThat(result.get(0).getNombreVeterinario()).isEqualTo("Dr. Juan");
    Assertions.assertThat(result.get(0).getNombreDroga()).isEqualTo("Antibiotico");
  }

  @Test
  public void TratamientoService_contarTratamientosPorMes_Map() {
    Map<String, Object> tratamientoMes = Map.of("mes", "octubre 2024", "cantidad", 2L);
    when(tratamientoRepository.contarTratamientosPorMes()).thenReturn(List.of(tratamientoMes));

    Map<String, Long> tratamientosPorMes = tratamientoService.contarTratamientosPorMes();

    Assertions.assertThat(tratamientosPorMes).isNotNull();
    Assertions.assertThat(tratamientosPorMes.get("octubre 2024")).isEqualTo(2L);
  }

  @Test
  public void TratamientoService_findTopVeterinariosByDroga_TopVeterinarios() {
    Map<String, Object> topVeterinario = Map.of("veterinario_nombre", "Dr. Juan", "droga_nombre", "Antibiotico",
        "total_unidades_vendidas", 5L);
    when(tratamientoRepository.findTopVeterinariosByDroga()).thenReturn(List.of(topVeterinario));

    List<Map<String, Object>> topVeterinarios = tratamientoService.findTopVeterinariosByDroga();

    Assertions.assertThat(topVeterinarios).isNotNull();
    Assertions.assertThat(topVeterinarios.size()).isEqualTo(1);
    Assertions.assertThat(topVeterinarios.get(0).get("veterinario_nombre")).isEqualTo("Dr. Juan");
  }

  @Test
  public void TratamientoService_searchById_NotFoundTratamiento() {
    when(tratamientoRepository.findById(1L)).thenReturn(Optional.empty());

    RuntimeException exception = Assertions.catchThrowableOfType(
        () -> tratamientoService.searchById(1L),
        RuntimeException.class);

    Assertions.assertThat(exception).hasMessageContaining("Tratamiento no encontrado con id: 1");
  }

}
