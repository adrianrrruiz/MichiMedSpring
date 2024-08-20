package com.example.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
