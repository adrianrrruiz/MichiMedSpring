package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Mascota;
import com.example.demo.repositorio.ClienteRepository;

@Service
public class ClienteService implements ClienteServiceInterface {

    @Autowired
    ClienteRepository repository;

    @Override
    public List<Mascota> getMascotas(Long id) {
        return repository.findById(id).get().getMascotas();
    }

    @Override
    public Cliente SearchById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Cliente> SearchAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        Cliente existingCliente = findByCedula(cliente.getCedula());
        if (existingCliente != null && !existingCliente.getId().equals(cliente.getId())) {
            throw new IllegalArgumentException("Ya existe un cliente con esta cédula");
        }
        repository.save(cliente);
    }

    @Override
    public void add(Cliente cliente) {
        Cliente existingCliente = findByCedula(cliente.getCedula());
        if (existingCliente != null) {
            throw new IllegalArgumentException("Ya existe un cliente con esta cédula");
        }
        repository.save(cliente);
    }

    @Override
    public Cliente findByCedula(String cedula) {
        return repository.findByCedula(cedula).get();
    }
}
