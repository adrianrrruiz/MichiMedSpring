package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String cedula;
    
    private String nombre;
    
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    private String contrasena;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Mascota> mascotas = new ArrayList<>();

    public Cliente(Long id, String cedula, String nombre, String email, String contrasena) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    // Constructor sin id
    public Cliente(String cedula, String nombre, String email, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    public Cliente() {
    }

    // Getters y Setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
}
