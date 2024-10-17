package com.example.demo.entidad;

public class HistorialMedicoDTO {
  private String fecha;
  private String nombreVeterinario;
  private String urlFotoVeterinario;
  private String nombreDroga;

  public HistorialMedicoDTO() {
  }

  public HistorialMedicoDTO(String fecha, String nombreVeterinario, String urlFotoVeterinario, String nombreDroga) {
    this.fecha = fecha;
    this.nombreVeterinario = nombreVeterinario;
    this.urlFotoVeterinario = urlFotoVeterinario;
    this.nombreDroga = nombreDroga;
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

  public String getNombreDroga() {
    return nombreDroga;
  }
}