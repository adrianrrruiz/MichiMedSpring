package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entidad.User;
import com.example.demo.servicio.ClienteServiceInterface;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/sign-in")
public class SignInController {

    @Autowired
    ClienteServiceInterface clienteService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> verifyCredentials(@RequestBody User user) {
        Long id = clienteService.verifyCredentials(user);
        Map<String, Object> response = new HashMap<>();
        if (id != -1L) {
            response.put("status", "ok");
            response.put("id", id);
            return ResponseEntity.ok(response);
        }
        response.put("status", "error");
        response.put("message", "Usuario o contraseña incorrectos");
        return ResponseEntity.status(401).body(response);
    }
}