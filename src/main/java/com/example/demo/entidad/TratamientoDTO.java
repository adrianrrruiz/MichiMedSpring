package com.example.demo.entidad;

public class TratamientoDTO {
  private Long id;
  private Mascota mascota;
  private Veterinario veterinario;
  private Droga droga;
  private String fecha;

  public TratamientoDTO() {
  }

  public TratamientoDTO(String fecha, Mascota mascota, Veterinario veterinario, Droga droga) {
    this.fecha = fecha;
    this.mascota = mascota;
    this.veterinario = veterinario;
    this.droga = droga;
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

  public Droga getDroga() {
    return droga;
  }

  public String getFecha() {
    return fecha;
  }
}
