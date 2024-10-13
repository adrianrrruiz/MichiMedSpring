package com.example.demo.servicio;

import java.util.Collection;
import java.util.List;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.User;

public interface ClienteServiceInterface {

    public Long verifyCredentials(User user);

    public List<Mascota> getMascotas(Long id);

    public Cliente SearchById(Long id);

    public Collection<Cliente> SearchAll();

    public void deleteById(Long id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);

    Cliente findByCedula(String cedula);

}