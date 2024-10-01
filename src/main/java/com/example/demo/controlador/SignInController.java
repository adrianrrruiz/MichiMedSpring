package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entidad.User;
import com.example.demo.servicio.ClienteServiceInterface;

@RestController
@RequestMapping("/sign-in")
public class SignInController {

    @Autowired
    ClienteServiceInterface clienteService;

    @GetMapping
    public ResponseEntity<User> signIn() {
        User user = new User("", "");
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> verifyCredentials(@RequestBody User user) {
        Long id = clienteService.verifyCredentials(user);
        if (id != -1L) {
            return ResponseEntity.ok("redirect:/clientes/mascotas/" + id);
        }
        return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
    }
}
