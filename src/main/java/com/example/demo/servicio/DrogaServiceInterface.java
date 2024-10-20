package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidad.Droga;

public interface DrogaServiceInterface {

    public List<Droga> SearchAll();

    public void add(Droga[] drogas);

    public void update(Droga droga);
}
