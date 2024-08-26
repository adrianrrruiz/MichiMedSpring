package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;

// http://localhost:8090/Clientes
@RequestMapping("/clientes")
@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    // http://localhost:8090/Clientes
    @GetMapping("")
    public String Clientes(Model model) {
        model.addAttribute("clientes", clienteService.SearchAll());
        return "clientes";
    }

    // http://localhost:8090/Clientes/update/{id}
    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.SearchById(id));
        return "updateCliente";
    }

    // http://localhost:8090/Clientes/update/{id}
    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable("id") Long id, @ModelAttribute Cliente cliente) {
        clienteService.update(cliente);
        return "redirect:/clientes";
    }

    // http://localhost:8090/Clientes/delete/{id}
    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
        return "redirect:/clientes";
    }

    // http://localhost:8090/Clientes/{id}
    @GetMapping("/{id}")
    public String InfoCliente(Model model, @PathVariable("id") Long id) {
        model.addAttribute("cliente", clienteService.SearchById(id));
        return "infoClientes";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Cliente cliente = new Cliente( null, null, null, null);
        model.addAttribute("cliente", cliente);
        return "clientesAdd";
    }

    @PostMapping("/add")
    public String addCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.add(cliente);
        return "redirect:/clientes";
    }

}