package com.example.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.User;
import com.example.demo.repositorio.ClienteRepository;

@Service
public class ClienteService implements ClienteServiceInterface {
    
    @Autowired
    ClienteRepository repository;

    @Override
    public boolean verifyCredentials(User user) {
        Cliente cliente = repository.getClienteByEmail(user.getEmail());
        if (cliente != null) {
            return cliente.getContrasena().equals(user.getPassword());
        }
        return false;
    }

   @Override
    public Cliente SearchById(int id) {
        return repository.getClienteById(id);
    }

    @Override
    public Collection<Cliente> SearchAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteByid(id);
    }

    @Override
    public void update(Cliente cliente) {
        repository.update(cliente);
    }

    @Override
    public void add(Cliente cliente) {
        repository.add(cliente);
    }


}
