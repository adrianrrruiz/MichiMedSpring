package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;

@RequestMapping("/clientes")
@Controller
public class ClienteController {

    String ruta = "clientes/";
    
    @Autowired
    ClienteService clienteService;

    @GetMapping("")
    public String Clientes(Model model) {
        model.addAttribute("clientes", clienteService.SearchAll());
        return ruta + "clientes";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.SearchById(id));
        return ruta + "updateCliente";
    }

    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable("id") Long id, @ModelAttribute Cliente cliente, Model model) {
        try {
            clienteService.update(cliente);
            return "redirect:/clientes";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return ruta + "updateCliente";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Ya existe un cliente con este correo electrónico.");
            return ruta + "updateCliente";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
        return "redirect:/clientes";
    }

    @GetMapping("/mascotas/{id}")
    public String findMascotasCliente(Model model, @PathVariable("id") Long id, @RequestParam(required = false) String nombre) {
        model.addAttribute("mascotas", clienteService.getMascotas(id));
        if (nombre != null) {
            model.addAttribute("nombreCliente", nombre);
            return "mascotas/mascotasCliente";
        }
        return "clientes/mascotasCliente";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Cliente cliente = new Cliente(null, null, null, null);
        model.addAttribute("cliente", cliente);
        return ruta + "clientesAdd";
    }

    @PostMapping("/add")
    public String addCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {
        try {
            clienteService.add(cliente);
            return "redirect:/clientes";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return ruta + "clientesAdd";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Ya existe un cliente con este correo electrónico.");
            return ruta + "clientesAdd";
        }
    }

    @GetMapping("/{id}")
    public String InfoCliente(Model model, @PathVariable("id") Long id) {
        model.addAttribute("cliente", clienteService.SearchById(id));
        return ruta + "infoClientes";
    }
}
