package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private int edad;
    private String raza;
    private Float peso;
    private String enfermedad;
    private String estado;
    private String fechaEntrada;
    private String fechaSalida;
    private String medicamento;

    @Column(length = 500)
    private String foto;

    @JsonIgnore
    @ManyToOne
    private Cliente cliente;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tratamiento", joinColumns = @JoinColumn(name = "mascota_id"), inverseJoinColumns = @JoinColumn(name = "veterinario_id"))
    private List<Veterinario> veterinarios = new ArrayList<>();

    public Mascota(Long id, String nombre, int edad, String raza, float peso, String enfermedad, String estado,
            String fechaEntrada, String fechaSalida, String medicamento, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.estado = estado;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.medicamento = medicamento;
        this.foto = foto;
    }

    // Constructor sin id
    public Mascota(String nombre, int edad, String raza, float peso, String enfermedad, String estado,
            String fechaEntrada, String fechaSalida, String medicamento, String foto) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.estado = estado;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.medicamento = medicamento;
        this.foto = foto;
    }
}
