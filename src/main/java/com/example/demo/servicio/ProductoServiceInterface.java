package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidad.Producto;

public interface ProductoServiceInterface {
  public Producto SearchById(Long id);

  public List<Producto> SearchAll();

  public void deleteById(Long id);

  public void update(Producto producto);

  public void add(Producto producto);
}
