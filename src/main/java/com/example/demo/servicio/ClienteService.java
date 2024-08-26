package com.example.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.User;
import com.example.demo.repositorio.ClienteRepository;

@Service
public class ClienteService implements ClienteServiceInterface {
    
    @Autowired
    ClienteRepository repository;

    @Override
    public boolean verifyCredentials(User user) {
        Optional<Cliente> cliente = repository.findByEmail(user.getEmail());
        if (cliente.isPresent()) {
            return cliente.get().getContrasena().equals(user.getPassword());
        }
        return false;
    }

    @Override
    public Cliente SearchById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Collection<Cliente> SearchAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void add(Cliente cliente) {
        repository.save(cliente);
    }


}
