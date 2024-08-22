package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/
@RequestMapping("/")
@Controller
public class LandingController {
    
    //http://localhost:8090/
    @GetMapping
    public String landing() {
        return "index";
    }
}
