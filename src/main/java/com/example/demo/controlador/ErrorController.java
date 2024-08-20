package com.example.demo.controlador;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(Model model, NotFoundException ex) {
        model.addAttribute("id", ex.getId());
        model.addAttribute("message", ex.getMessage()); // Añadir el mensaje de la excepción al modelo
        return ("error"); // Nombre de la vista de error
    }


}
