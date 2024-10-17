package com.example.demo.servicio;

import com.example.demo.entidad.User;

public interface AdministradorServiceInterface {
  public Long verifyCredentials(User user);
}
