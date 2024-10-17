package com.example.demo.entidad;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Droga {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private double precioCompra;
    private double precioVenta;
    private int uniDisp;
    private int uniVend;

    @JsonIgnore
    @OneToMany(mappedBy = "droga")
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Droga() {
    }

    public Droga(String nombre, double precioCompra, double precioVenta, int uniDisp, int uniVend) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.uniDisp = uniDisp;
        this.uniVend = uniVend;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getUniDisp() {
        return uniDisp;
    }

    public void setUniDisp(int uniDisp) {
        this.uniDisp = uniDisp;
    }

    public int getUniVend() {
        return uniVend;
    }

    public void setUniVend(int uniVend) {
        this.uniVend = uniVend;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
}
