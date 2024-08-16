package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/sign-in
@RequestMapping("/sign-in")
@Controller
public class SignInController {

    // http://localhost:8090/sign-in
    @GetMapping
    public String SignIn(Model model) {
        return "signIn";
    }
}
