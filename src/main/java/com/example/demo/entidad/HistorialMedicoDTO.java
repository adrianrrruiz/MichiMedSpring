package com.example.demo.entidad;

import java.util.List;

public class HistorialMedicoDTO {
  private String fecha;
  private String nombreVeterinario;
  private String urlFotoVeterinario;
  private List<String> nombresDrogas;

  public HistorialMedicoDTO() {
  }

  public HistorialMedicoDTO(String fecha, String nombreVeterinario, String urlFotoVeterinario,
      List<String> nombresDrogas) {
    this.fecha = fecha;
    this.nombreVeterinario = nombreVeterinario;
    this.urlFotoVeterinario = urlFotoVeterinario;
    this.nombresDrogas = nombresDrogas;
  }

  public String getFecha() {
    return fecha;
  }

  public String getNombreVeterinario() {
    return nombreVeterinario;
  }

  public String getUrlFotoVeterinario() {
    return urlFotoVeterinario;
  }

  public List<String> getNombresDrogas() {
    return nombresDrogas;
  }
}