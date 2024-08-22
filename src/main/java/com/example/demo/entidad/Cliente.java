package com.example.demo.entidad;

import javax.validation.constraints.Null;

public class Cliente {
    @Null
    private Integer id; // Cambiado de int a Integer
    private String cedula;
    private String nombre;
    private String correo;
    private String contrasena;

    public Cliente(Integer id, String cedula, String nombre, String correo, String contrasena) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}