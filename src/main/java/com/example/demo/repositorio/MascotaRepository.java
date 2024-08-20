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
        data.put(1, new Mascota(1,"Michito", 3, "angola", 5.3f, "", "En tratamiento", "20/09/18", "20/09/18",
                "esomeprazol",
                "https://images.ctfassets.net/denf86kkcx7r/4IPlg4Qazd4sFRuCUHIJ1T/f6c71da7eec727babcd554d843a528b8/gatocomuneuropeo-97?fm=webp&w=612"));
        data.put(2, new Mascota(2,"Bella", 4, "minecoon", 4.8f, "", "En tratamiento", "15/10/18", "20/09/18",
                "esomeprazol", "https://urgenciesveterinaries.com/wp-content/uploads/2023/09/survet-gato-caida-pelo-01.jpeg"));
        data.put(3, new Mascota(3,"Tito", 2, "angola", 3.2f, "", "Tratado", "05/12/18", "20/09/18",
                "esomeprazol", "https://cdn.shopify.com/s/files/1/0268/6861/files/Gato-siames-1200x900_480x480.jpg?v=1678812075"));
        data.put(4, new Mascota(4,"Lucy", 5, "persa", 3.7f, "", "En tratamiento", "10/01/19", "20/09/18",
                "esomeprazol", "https://www.lapulgada.co/cdn/shop/collections/gato-persa-2_675x675.png?v=1721917322"));
    }

    public Mascota getMascotaById(int id) {
        return data.get(id);
    }

    public Collection<Mascota> findAll() {
        return data.values();
    }

    public void deleteByid(int id){
        data.remove(id);
    }

    public void update(Mascota mascota){
        data.put(mascota.getId(), mascota);
    }

    public void add(Mascota mascota){
        int tam = data.size();
        int lastId = data.get(tam).getId();
        mascota.setId(lastId + 1);
        data.put(mascota.getId(),mascota);
    }
}
