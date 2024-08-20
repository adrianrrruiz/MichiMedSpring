package com.example.demo.controlador;

public class NotFoundException extends RuntimeException {

    private int id;

    public NotFoundException(int id) {
        super("No se ha encontrado el id: " + id);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
