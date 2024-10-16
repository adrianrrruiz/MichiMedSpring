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

@Entity
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

    public Veterinario() {
    }

    public Veterinario(String cedula, String nombre, String contrasena, String especialidad, String urlFoto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.urlFoto = urlFoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

}
