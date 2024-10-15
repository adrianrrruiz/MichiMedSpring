package com.example.demo.controlador;

import java.util.List;
import com.example.demo.entidad.Mascota;

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

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteServiceInterface;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/clientes")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    ClienteServiceInterface clienteService;

    // http://localhost:8090/clientes
    @GetMapping("")
    public List<Cliente> getAllClientes() {
        return clienteService.SearchAll();
    }

    // http://localhost:8090/clientes/{id}
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable("id") Long id) {
        return clienteService.SearchById(id);
    }

    // http://localhost:8090/clientes/mascotas/{id}
    @GetMapping("/mascotas/{id}")
    @Operation(summary = "Obtener las mascotas de un cliente")
    public List<Mascota> getMascotasCliente(@PathVariable("id") Long id) {
        return clienteService.getMascotas(id);
    }

    // http://localhost:8090/clientes/add
    @PostMapping("/add")
    public void addCliente(@RequestBody Cliente cliente) {
        clienteService.add(cliente);
    }

    // http://localhost:8090/clientes/update
    @PutMapping("/update")
    public void updateCliente(@RequestBody Cliente cliente) {
        List<Mascota> mascotas = clienteService.SearchById(cliente.getId()).getMascotas();
        cliente.setMascotas(mascotas);
        clienteService.update(cliente);
    }

    // http://localhost:8090/clientes/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
    }
}