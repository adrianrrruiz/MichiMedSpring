package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Mascota;

public interface ClienteServiceInterface {

    public List<Mascota> getMascotas(Long id);

    public Cliente SearchById(Long id);

    public List<Cliente> SearchAll();

    public void deleteById(Long id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);

    Cliente findByCedula(String cedula);

}