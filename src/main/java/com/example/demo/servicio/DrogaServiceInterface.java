package com.example.demo.servicio;

import java.io.IOException;
import java.util.Collection;

import com.example.demo.entidad.Droga;

public interface DrogaServiceInterface {

    public void cargarMedicamentosDesdeArchivo(String filePath) throws IOException;

    public Droga searchById(Long id);

    public Collection<Droga> getAllDrogas();

    public void update(Droga droga);

    public void deleteById(Long id);

    public void add(Droga droga);
}
