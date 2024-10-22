package com.example.demo.servicio;

import java.util.List;
import java.util.Map;

import com.example.demo.entidad.HistorialMedicoDTO;
import com.example.demo.entidad.Tratamiento;

public interface TratamientoServiceInterface {

    public Tratamiento searchById(Long id);

    public List<Tratamiento> SearchAll();

    public void deleteById(Long id);

    public Tratamiento update(Tratamiento tratamiento);

    public Tratamiento add(Tratamiento tratamiento);

    public List<HistorialMedicoDTO> findHistorialMedicoByMascotaId(Long id);

    public Map<String, Long> contarTratamientosPorMes();

    public List<Map<String, Object>> findTopVeterinariosByDroga();
}
