package com.example.demo.servicio;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.User;
import java.util.Collection;

public interface ClienteServiceInterface {

    public boolean verifyCredentials(User user);

    public Cliente SearchById(int id );

    public Collection<Cliente> SearchAll();

    public void deleteById(int id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);
}