package com.example.demo.entidad;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

    public Droga(String nombre, double precioCompra, double precioVenta, int uniDisp, int uniVend) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.uniDisp = uniDisp;
        this.uniVend = uniVend;
    }
}
