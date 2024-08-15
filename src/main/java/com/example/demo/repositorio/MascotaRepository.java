package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Mascota;

@Repository
public class MascotaRepository {

    private Map<Integer, Mascota> data = new HashMap<>();

    public MascotaRepository() {
        data.put(1, new Mascota("Michito", 3, "persa", 5.3f, "gastritis", "En tratamiento", "20/09/18", "20/09/18",
                "esomeprazol",
                "https://images.ctfassets.net/denf86kkcx7r/4IPlg4Qazd4sFRuCUHIJ1T/f6c71da7eec727babcd554d843a528b8/gatocomuneuropeo-97?fm=webp&w=612"));
        data.put(2, new Mascota("Bella", 4, "persa", 4.8f, "gastritis", "En tratamiento", "15/10/18", "20/09/18",
                "esomeprazol", "dksanbhjda"));
        data.put(3, new Mascota("Tito", 2, "persa", 3.2f, "gastritis", "En tratamiento", "05/12/18", "20/09/18",
                "esomeprazol", "dksanbhjda"));
        data.put(4, new Mascota("Lucy", 5, "persa", 3.7f, "gastritis", "En tratamiento", "10/01/19", "20/09/18",
                "esomeprazol", "dksanbhjda"));
    }

    public Mascota getMascotaById(int id) {
        return data.get(id);
    }

    public Collection<Mascota> findAll() {
        return data.values();
    }
}
