package com.example.demo.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOs.User;
import com.example.demo.entidad.Administrador;
import com.example.demo.repositorio.AdministradorRepository;

@Service
public class AdministradorService implements AdministradorServiceInterface {

  @Autowired
  AdministradorRepository administradorRepository;

  @Override
  public Long verifyCredentials(User user) {
    Optional<Administrador> admin = administradorRepository.findByCedula(user.getCedula());

    if (admin.isPresent()) {
      String adminContrasena = admin.get().getContrasena();
      String userPassword = user.getPassword();

      // Verificar que ambas contraseñas no sean null antes de la comparación
      if (adminContrasena != null && adminContrasena.equals(userPassword)) {
        return admin.get().getId();
      }
    }

    return -1L;
  }

  public Administrador findByCedula(String cedula) {
    Optional<Administrador> admin = administradorRepository.findByCedula(cedula);
    return admin.get();
  }

}
