package com.example.demo.entidad;

import javax.validation.constraints.Null;

public class Mascota {
    @Null
    private int id;
    private String nombre;
    private int edad;
    private String raza;
    private Float peso;
    private String enfermedad;
    private String estado;
    private String fechaEntrada;
    private String fechaSalida;
    private String medicamento;
    private String foto;

    public Mascota(int id, String nombre, int edad, String raza, float peso, String enfermedad, String estado,
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
