package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Mascota;

@Repository
public class MascotaRepository {

    private Map<Integer, Mascota> mascotas = new HashMap<>();

    public MascotaRepository() {
        mascotas.put(1, new Mascota(1, "Firulais", "Persa", 3, 5.5, "Ninguna", "https://www.petdarling.com/articulos/wp-content/uploads/2019/07/gato-persa-1.jpg", "En tratamiento"));
        mascotas.put(2, new Mascota(2, "Toby", "Siames", 2, 4.5, "Ninguna", "https://www.petdarling.com/articulos/wp-content/uploads/2019/07/gato-siames-1.jpg", "En tratamiento"));
        mascotas.put(3, new Mascota(3, "Mishu", "Bengala", 1, 3.5, "Ninguna", "https://www.petdarling.com/articulos/wp-content/uploads/2019/07/gato-bengala-1.jpg", "En tratamiento"));
    }

    public Mascota findById(int id){
        return mascotas.get(id);
    }

    public Collection<Mascota> findAll(){
        return mascotas.values();
    }
}