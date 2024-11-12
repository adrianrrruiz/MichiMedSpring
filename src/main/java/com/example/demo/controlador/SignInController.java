package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTOs.User;
import com.example.demo.security.JWTGenerator;
import com.example.demo.servicio.AdministradorServiceInterface;
import com.example.demo.servicio.UserService;
import com.example.demo.servicio.VeterinarioServiceInterface;
import com.example.demo.servicio.EmailService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
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
    AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    JWTGenerator jwtGenerator;

    @PostMapping
    public ResponseEntity login(@RequestBody User user) {

        boolean isAdmin = false;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getCedula(), user.getPassword()));

        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ADMINISTRADOR")) {
                isAdmin = true;
                break;
            }
        }

        long id = -1L;
        if (isAdmin) {
            id = administradorService.findByCedula(user.getCedula()).getId();
        } else {
            id = veterinarioService.findByCedula(user.getCedula()).getId();
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        Map<String, Object> response = new HashMap<>();
        response.put("isAdmin", isAdmin);
        response.put("token", token);
        response.put("id", id);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @PostMapping("/reset")
    public void resetPassword(@RequestBody Map<String, String> payload) {
        String token = payload.get("token");
        String newPassword = payload.get("newPassword");
        if (userService.validatePasswordResetToken(token)) {
            userService.updatePassword(token, newPassword);
        } else {
            throw new RuntimeException("Token no válido o expirado");
        }
    }

    @PostMapping("/request-reset")
    public ResponseEntity requestPasswordReset(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String token = userService.generatePasswordResetToken(email);
        String message = "Por favor, copia este código para poder hacer tu reset de contraseña: " + token;
        emailService.sendEmail(email, "Solicitud de restablecimiento de contraseña", message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}