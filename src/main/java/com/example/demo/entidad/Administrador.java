package com.example.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Administrador {

  @Id
  @GeneratedValue
  Long id;

  private String cedula;
  private String nombre;
  private String contrasena;

  public Administrador(String cedula, String nombre, String contrasena) {
    this.cedula = cedula;
    this.nombre = nombre;
    this.contrasena = contrasena;
  }
}
