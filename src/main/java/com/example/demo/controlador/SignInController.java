package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTOs.User;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.servicio.AdministradorServiceInterface;
import com.example.demo.servicio.VeterinarioServiceInterface;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/sign-in")
public class SignInController {

    @Autowired
    AdministradorServiceInterface administradorService;

    @Autowired
    VeterinarioServiceInterface veterinarioService;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity login(@RequestBody User user) {
        // Long id = veterinarioService.verifyCredentials(user);
        // Long idAdmin = administradorService.verifyCredentials(user);
        // Map<String, Object> response = new HashMap<>();
        // if (idAdmin != -1L) {
        // response.put("status", "ok");
        // response.put("id", idAdmin);
        // response.put("admin", true);
        // return ResponseEntity.ok(response);
        // }
        // if (id != -1L) {
        // response.put("status", "ok");
        // response.put("id", id);
        // response.put("admin", false);
        // return ResponseEntity.ok(response);
        // }
        // response.put("status", "error");
        // response.put("message", "Usuario o contraseña incorrectos");
        // return ResponseEntity.status(401).body(response);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getCedula(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<String>("Usuario autenticado", HttpStatus.OK);

    }
}