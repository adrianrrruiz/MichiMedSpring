package com.example.demo.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoHandlerFoundException(Model model) {
        model.addAttribute("errorCode", 404);
        model.addAttribute("message", "La página que buscas no existe.");
        return "error";
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(Model model, NotFoundException ex) {
        model.addAttribute("errorCode", 404);
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Model model, Exception ex) {
        model.addAttribute("errorCode", 500);
        model.addAttribute("message", "Ocurrió un error en el servidor. Por favor, intenta de nuevo más tarde.");
        return "error";
    }
}
