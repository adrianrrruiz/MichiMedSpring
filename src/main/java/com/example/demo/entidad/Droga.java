package com.example.demo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Droga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDroga;  // Clave primaria (PK)

    @Column(nullable = false)
    private String nombre;  

    @Column(nullable = false, unique = true)
    private String clave;  

    @Column(nullable = false)
    private String tipo;  

    @Column(nullable = false, precision = 10, scale = 2)
    private double prComp;  

    @Column(nullable = false, precision = 10, scale = 2)
    private double prVend; 

    @Column(nullable = false)
    private Integer uniDisp;  

    @Column(nullable = false)
    private Integer uniVend;  

    // Constructor vacío
    public Droga() {
    }

    // Constructor con parámetros
    public Droga(String nombre, String clave, String tipo, double prComp, double prVend, Integer uniDisp, Integer uniVend) {
        this.nombre = nombre;
        this.clave = clave;
        this.tipo = tipo;
        this.prComp = prComp;
        this.prVend = prVend;
        this.uniDisp = uniDisp;
        this.uniVend = uniVend;
    }

    // Getters y Setters
    public Integer getIdDroga() {
        return idDroga;
    }

    public void setIdDroga(Integer idDroga) {
        this.idDroga = idDroga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrComp() {
        return prComp;
    }

    public void setPrComp(double prComp) {
        this.prComp = prComp;
    }

    public double getPrVend() {
        return prVend;
    }

    public void setPrVend(double prVend) {
        this.prVend = prVend;
    }

    public Integer getUniDisp() {
        return uniDisp;
    }

    public void setUniDisp(Integer uniDisp) {
        this.uniDisp = uniDisp;
    }

    public Integer getUniVend() {
        return uniVend;
    }

    public void setUniVend(Integer uniVend) {
        this.uniVend = uniVend;
    }

}
