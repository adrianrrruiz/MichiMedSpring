package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Producto;
import com.example.demo.servicio.ProductoServiceInterface;

@RequestMapping("/productos")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

  String ruta = "productos/";

  @Autowired
  ProductoServiceInterface productoService;

  // http://localhost:8090/productos
  @GetMapping("")
  public List<Producto> Productos() {
    return productoService.SearchAll();
  }

  // http://localhost:8090/productos/{id}
  @GetMapping("/{id}")
  public Producto InfoProducto(@PathVariable("id") Long id) {
    return productoService.SearchById(id);
  }

  // http://localhost:8090/productos/add
  @PostMapping("/add")
  public void addProducto(@RequestBody Producto producto) {
    productoService.add(producto);
  }

  // http://localhost:8090/productos/update
  @PutMapping("/update")
  public void updateProducto(@RequestBody Producto producto) {
    productoService.update(producto);
  }

  // http://localhost:8090/productos/delete/{id}
  @DeleteMapping("/delete/{id}")
  public void deleteProducto(@PathVariable("id") Long id) {
    productoService.deleteById(id);
  }

}
