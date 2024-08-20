package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.User;
import com.example.demo.servicio.ClienteServiceInterface;
import org.springframework.web.bind.annotation.PostMapping;


// http://localhost:8090/sign-in
@RequestMapping("/sign-in")
@Controller
public class SignInController {

    @Autowired
    ClienteServiceInterface clienteService;

    // http://localhost:8090/sign-in
    @GetMapping
    public String SignIn(Model model) {
        User user = new User("", "");

        model.addAttribute("user", user);
        model.addAttribute("error", "");

        return "signIn";
    }

    // http://localhost:8090/sign-in
    @PostMapping
    public String verifyCredentials(@ModelAttribute("user") User user, Model model) {
        
        if(clienteService.verifyCredentials(user)){
            return "redirect:/mascotas";
        }
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "signIn";
    }
    
}