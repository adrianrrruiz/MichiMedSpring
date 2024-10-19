package com.example.demo.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entidad.Mascota;
import com.example.demo.repositorio.MascotaRepository;

@DataJpaTest // Crea una base de datos h2 para pruebas
@RunWith(SpringRunner.class) // Permite correr pruebas de Spring
public class MascotaRepositoryTest {

  @Autowired
  private MascotaRepository mascotaRepository;

  @BeforeEach // Se ejecuta antes de cada prueba
  public void setUp() {

  }

  @Test
  public void MascotaRepository_save_Mascota() {
    // 1. Arrange - Preparar
    Mascota mascota = new Mascota("Michito", 2, "Gato", 3.5f, "Ninguna", "En adopcion", "2021-09-01", "2021-09-10",
        "Ninguno", "foto.jpg");

    // 2. Act - Actuar
    Mascota savedMascota = mascotaRepository.save(mascota);

    // 3. Assert - Afirmar
    Assertions.assertThat(savedMascota).isNotNull();
  }

  @Test
  public void MascotaRepository_findAll_NotEmptyList() {

    Mascota mascota = new Mascota("Michito", 2, "Gato", 3.5f, "Ninguna", "En adopcion", "2021-09-01", "2021-09-10",
        "Ninguno", "foto.jpg");
    Mascota mascota2 = new Mascota("Michito2", 2, "Gato", 3.5f, "Ninguna", "En adopcion", "2021-09-01", "2021-09-10",
        "Ninguno", "foto.jpg");

    mascotaRepository.save(mascota);
    mascotaRepository.save(mascota2);
    List<Mascota> mascotas = mascotaRepository.findAll();

    Assertions.assertThat(mascotas).isNotEmpty();
    Assertions.assertThat(mascotas.size()).isEqualTo(2);
    Assertions.assertThat(mascotas.size()).isGreaterThan(0);
  }
}