package com.example.demo.controlador;

import java.util.Collection;
import java.util.List;
import com.example.demo.entidad.Mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/clientes")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    String ruta = "clientes/";

    @Autowired
    ClienteService clienteService;

    // http://localhost:8090/clientes
    @GetMapping("")
    public Collection<Cliente> getAllClientes() {
        return clienteService.SearchAll();
    }

    @GetMapping("/mascotas/{id}")    
    public List<Mascota> getMascotasCliente(@PathVariable("id") Long id) {
        return clienteService.getMascotas(id);
    }
    

    // http://localhost:8090/clientes/{id}
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable("id") Long id) {
        return clienteService.SearchById(id);
    }

    // http://localhost:8090/clientes/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return ruta + "clientesAdd";
    }

    // http://localhost:8090/clientes/add
    @PostMapping("/add")
    public String addCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {
        try {
            clienteService.add(cliente);
            return "redirect:/clientes";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return ruta + "clientesAdd";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Ya existe un cliente con esta cédula.");
            return ruta + "clientesAdd";
        }
    }

    // http://localhost:8090/clientes/update/{id}
    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.SearchById(id));
        return ruta + "updateCliente";
    }

    // http://localhost:8090/clientes/update
    @PutMapping("/update")
    public void updateCliente(@RequestBody Cliente cliente) {
        clienteService.update(cliente);
    }

    // http://localhost:8090/clientes/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
    }
}