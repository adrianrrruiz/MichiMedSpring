package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

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
    mascotaRepository.save(new Mascota("Michito", 3, "angola", 5.3f, "", "En tratamiento", "20/09/18",
        "20/09/18",
        "esomeprazol",
        "https://images.ctfassets.net/denf86kkcx7r/4IPlg4Qazd4sFRuCUHIJ1T/f6c71da7eec727babcd554d843a528b8/gatocomuneuropeo-97?fm=webp&w=612"));
    mascotaRepository.save(new Mascota("Bella", 4, "minecoon", 4.8f, "", "En tratamiento", "15/10/18",
        "20/09/18",
        "esomeprazol",
        "https://urgenciesveterinaries.com/wp-content/uploads/2023/09/survet-gato-caida-pelo-01.jpeg"));
    mascotaRepository.save(new Mascota("Tito", 2, "angola", 3.2f, "", "Tratado", "05/12/18", "20/09/18",
        "esomeprazol",
        "https://cdn.shopify.com/s/files/1/0268/6861/files/Gato-siames-1200x900_480x480.jpg?v=1678812075"));
    mascotaRepository.save(new Mascota("Lucy", 5, "persa", 3.7f, "", "En tratamiento", "10/01/19",
        "20/09/18",
        "esomeprazol",
        "https://www.lapulgada.co/cdn/shop/collections/gato-persa-2_675x675.png?v=1721917322"));
    mascotaRepository.save(new Mascota("Simba", 3, "siames", 4.0f, "", "En tratamiento", "01/02/19",
        "20/09/18",
        "esomeprazol", "https://images.unsplash.com/photo-1518791841217-8f162f1e1131"));
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

    Mascota mascota = new Mascota("Nala", 2, "maine coon", 6.1f, "", "Tratado", "03/03/19", "20/09/18",
        "esomeprazol",
        "https://cdn.pixabay.com/photo/2017/11/09/21/41/cat-2934720_960_720.jpg");
    Mascota mascota2 = new Mascota("Max", 1, "angora", 4.5f, "", "En tratamiento", "04/04/19",
        "20/09/18",
        "esomeprazol",
        "https://plus.unsplash.com/premium_photo-1673461703605-0c6cc77e1a35?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Z2F0b3xlbnwwfHwwfHx8MA%3D%3D");

    mascotaRepository.save(mascota);
    mascotaRepository.save(mascota2);
    List<Mascota> mascotas = mascotaRepository.findAll();

    Assertions.assertThat(mascotas).isNotNull();
    Assertions.assertThat(mascotas.size()).isEqualTo(7);
    Assertions.assertThat(mascotas.size()).isGreaterThan(0);
  }

  @Test
  public void MascotaRepository_findById_FindWrongIndex() {
    Long index = -1l;

    Optional<Mascota> mascota = mascotaRepository.findById(index);

    Assertions.assertThat(mascota).isEmpty();
  }

  @Test
  public void MascotaRepository_findById_FindCorrectIndex() {
    Long index = 1l;

    Optional<Mascota> mascota = mascotaRepository.findById(index);

    Assertions.assertThat(mascota).isNotEmpty();
  }

  @Test
  public void MascotaRepository_updateById_Mascota() {
    Long index = 2l;

    Optional<Mascota> mascota = mascotaRepository.findById(index);
    mascota.get().setNombre("Michito");
    mascota.get().setEdad(3);
    Mascota mascotaUpdated = mascotaRepository.save(mascota.get());

    Assertions.assertThat(mascotaUpdated).isNotNull();
    Assertions.assertThat(mascotaUpdated.getNombre()).isEqualTo("Michito");
    Assertions.assertThat(mascotaUpdated.getEdad()).isEqualTo(3);
  }

  @Test
  public void MascotaRepository_deleteById_EmptyMascota() {
    Long index = 1l;

    mascotaRepository.deleteById(index);

    Assertions.assertThat(mascotaRepository.findById(index)).isEmpty();
  }

}