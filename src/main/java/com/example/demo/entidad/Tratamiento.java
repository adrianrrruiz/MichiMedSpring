package com.example.demo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

    public Tratamiento(String fecha) {
        this.fecha = fecha;
    }

    public Tratamiento(String fecha, Mascota mascota, Veterinario veterinario) {
        this.fecha = fecha;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }
}
