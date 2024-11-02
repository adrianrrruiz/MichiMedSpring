package com.example.demo.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HistorialMedicoDTO {
  private String fecha;
  private String nombreVeterinario;
  private String urlFotoVeterinario;
  private String nombreDroga;

  public HistorialMedicoDTO(String fecha, String nombreVeterinario, String urlFotoVeterinario, String nombreDroga) {
    this.fecha = fecha;
    this.nombreVeterinario = nombreVeterinario;
    this.urlFotoVeterinario = urlFotoVeterinario;
    this.nombreDroga = nombreDroga;
  }
}