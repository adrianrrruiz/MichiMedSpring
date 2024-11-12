package com.example.demo.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreCliente;

    @Column(nullable = false)
    private String nombreMascota;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String fecha;

    public Cita(String nombreCliente, String nombreMascota, String descripcion, String fecha) {
        this.nombreCliente = nombreCliente;
        this.nombreMascota = nombreMascota;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
}