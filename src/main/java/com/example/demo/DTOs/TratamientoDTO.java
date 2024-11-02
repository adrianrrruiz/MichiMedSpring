package com.example.demo.DTOs;

import com.example.demo.entidad.Droga;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Veterinario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TratamientoDTO {
  private Long id;
  private Mascota mascota;
  private Veterinario veterinario;
  private Droga droga;
  private String fecha;

  public TratamientoDTO(String fecha, Mascota mascota, Veterinario veterinario, Droga droga) {
    this.fecha = fecha;
    this.mascota = mascota;
    this.veterinario = veterinario;
    this.droga = droga;
  }
}
