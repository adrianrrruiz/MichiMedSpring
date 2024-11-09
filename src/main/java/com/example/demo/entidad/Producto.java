package com.example.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Producto {

  @Id
  @GeneratedValue
  private Long id;
  private String nombre;
  private String descripcion;
  private double precio;
  private String foto;

  public Producto(Long id, String nombre, String descripcion, double precio, String foto) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.foto = foto;
  }

  public Producto(String nombre, String descripcion, double precio, String foto) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.foto = foto;
  }
}
