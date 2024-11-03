package com.example.demo.security;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Administrador;
import com.example.demo.entidad.Role;
import com.example.demo.entidad.UserEntity;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.RoleRepository;
import com.example.demo.repositorio.UserRepository;

//Para pasar de UserEntity a UserDetails(User estandar que usa Spring Security)
@Service
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  // UserDetails: Interfaz
  // User: Clase que implementa UserDetails
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserEntity> userDB = userRepository.findByUsername(username);

    UserDetails userDetails = new User(userDB.get().getUsername(), userDB.get().getPassword(),
        mapToGrantedAuthorities(userDB.get().getRoles()));

    return userDetails;
  }

  // Para pasar Roles de DB a GrantedAuthority
  private Collection<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
  }

  public UserEntity VeterinarioToUser(Veterinario veterinario) {
    UserEntity user = new UserEntity();
    user.setUsername(veterinario.getCedula());
    user.setPassword(passwordEncoder.encode(veterinario.getContrasena()));

    Role roles = roleRepository.findByName("VETERINARIO").get();
    user.setRoles(List.of(roles));
    return user;
  }

  public UserEntity AdministradorToUser(Administrador administrador) {
    UserEntity user = new UserEntity();
    user.setUsername(administrador.getCedula());
    user.setPassword(passwordEncoder.encode(administrador.getContrasena()));

    Role roles = roleRepository.findByName("ADMINISTRADOR").get();
    user.setRoles(List.of(roles));
    return user;
  }

}
