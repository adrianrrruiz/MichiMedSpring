package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Droga;
import com.example.demo.repositorio.DrogaRepository;

@Service
public class DrogaService implements DrogaServiceInterface {

    @Autowired
    DrogaRepository drogaRepository;

    @Override
    public List<Droga> SearchAll() {
        return drogaRepository.findAll();
    }

    @Override
    public void add(Droga[] drogas) {
        for (Droga droga : drogas) {
            drogaRepository.save(droga);
        }
    }
}
