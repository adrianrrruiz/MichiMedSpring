package com.example.demo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor // Para poner el builder toca poner este
public class Administrador {

  @OneToOne(cascade = CascadeType.ALL)
  @JsonIgnore
  private UserEntity user;

  @Id
  @GeneratedValue
  Long id;

  private String cedula;
  private String nombre;
  private String email;
  @Transient // No se guarda en la base de datos
  private String contrasena;

  public Administrador(String cedula, String nombre, String contrasena) {
    this.cedula = cedula;
    this.nombre = nombre;
    this.contrasena = contrasena;

  }
}
