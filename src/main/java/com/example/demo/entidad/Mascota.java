package com.example.demo.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
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

    @ManyToOne
    private Cliente cliente;

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

    public Mascota() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
