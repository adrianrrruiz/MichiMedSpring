package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Veterinario {

    @Id
    @GeneratedValue
    Long id;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "tratamiento", joinColumns = @JoinColumn(name = "veterinario_id", nullable = true), inverseJoinColumns = @JoinColumn(name = "mascota_id", nullable = true))
    private List<Mascota> mascotas = new ArrayList<>();

    private String cedula;
    private String nombre;
    private String contrasena;
    private String especialidad;
    private String urlFoto;

    public Veterinario(String cedula, String nombre, String contrasena, String especialidad, String urlFoto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.urlFoto = urlFoto;
    }
}
