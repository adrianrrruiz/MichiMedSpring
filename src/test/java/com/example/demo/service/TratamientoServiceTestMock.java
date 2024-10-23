package com.example.demo.service;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entidad.Tratamiento;
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

  // @Test
  // public void TratamientoService_deleteById_EmptyTratamiento() {
  // Tratamiento tratamiento = new Tratamiento("22/10/2024");

  // when(tratamientoRepository.findById(1L)).thenReturn(
  // Optional.of(tratamiento));

  // tratamientoService.deleteById(1L);

  // Assertions.assertThat(tratamientoRepository.findById(1L)).isEmpty();
  // }

  @Test
  public void TratamientoService_findHistorialMedicoByMascotaId_HistorialMedicoDTOList() {
    when(tratamientoRepository.findAll()).thenReturn(
        List.of(
            new Tratamiento("22/10/2024"),
            new Tratamiento("23/10/2024")));

    List<Tratamiento> tratamientos = tratamientoService.SearchAll();

    Assertions.assertThat(tratamientos).isNotNull();
    Assertions.assertThat(tratamientos.size()).isEqualTo(2);
  }

}
