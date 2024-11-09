package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Producto;
import com.example.demo.repositorio.ProductoRepository;

@Service
public class ProductoService implements ProductoServiceInterface {

  @Autowired
  ProductoRepository repository;

  @Override
  public Producto SearchById(Long id) {
    return repository.findById(id).get();
  }

  @Override
  public List<Producto> SearchAll() {
    return repository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  @Override
  public void update(Producto Producto) {
    repository.save(Producto);
  }

  @Override
  public void add(Producto Producto) {
    repository.save(Producto);
  }
}
