package com.example.demo.servicio;

import com.example.demo.DTOs.User;
import com.example.demo.entidad.Administrador;

public interface AdministradorServiceInterface {
  public Long verifyCredentials(User user);

  public Administrador findByCedula(String cedula);
}
