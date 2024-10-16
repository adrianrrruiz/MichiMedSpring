package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

public class TratamientoDTO {
  private Long id;
  private Mascota mascota;
  private Veterinario veterinario;
  private List<Droga> drogas = new ArrayList<>();
  private String fecha;

  public TratamientoDTO() {
  }

  public TratamientoDTO(String fecha, Mascota mascota, Veterinario veterinario, List<Droga> drogas) {
    this.fecha = fecha;
    this.mascota = mascota;
    this.veterinario = veterinario;
    this.drogas = drogas;
  }

  public Long getId() {
    return id;
  }

  public Mascota getMascota() {
    return mascota;
  }

  public Veterinario getVeterinario() {
    return veterinario;
  }

  public List<Droga> getDrogas() {
    return drogas;
  }

  public String getFecha() {
    return fecha;
  }
}
