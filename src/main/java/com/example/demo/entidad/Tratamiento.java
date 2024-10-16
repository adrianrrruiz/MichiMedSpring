package com.example.demo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento {

    @Id
    @GeneratedValue
    Long id;

    @JsonIgnore
    @ManyToOne
    private Mascota mascota;

    @JsonIgnore
    @ManyToOne
    private Veterinario veterinario;

    @JsonIgnore
    @ManyToOne
    private Droga droga;

    private String fecha;

    public Tratamiento() {
    }

    public Tratamiento(String fecha) {
        this.fecha = fecha;
    }

    public Tratamiento(String fecha, Mascota mascota, Veterinario veterinario) {
        this.fecha = fecha;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Droga getDroga() {
        return droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }

}
