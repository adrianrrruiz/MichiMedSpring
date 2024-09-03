package com.example.demo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
    
    @ManyToOne
    private Tratamiento tratamiento;

    public Droga() {
    }

    public Droga(String nombre, double precioCompra, double precioVenta, int uniDisp, int uniVend) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.uniDisp = uniDisp;
        this.uniVend = uniVend;
    }

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

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
    

    
}
