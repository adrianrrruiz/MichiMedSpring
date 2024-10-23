package com.example.demo.controller;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import com.example.demo.controlador.VeterinarioController;
import com.example.demo.entidad.Veterinario;
import com.example.demo.servicio.VeterinarioService;

@WebMvcTest(controllers = VeterinarioController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class VeterinarioTestController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private VeterinarioService veterinarioService;

    @Test
    public void VeterinarioController_agregarVeterinario_Veterinario() throws Exception {
        Veterinario veterinario = new Veterinario(
                "123456789",
                "Juan Pérez",
                "1234",
                "Cirugía",
                "https://randomuser.me/api/portraits/men/1.jpg");

        when(veterinarioService.add(Mockito.any(Veterinario.class))).thenReturn(veterinario);

        ResultActions response = mockMvc.perform(
                post("/veterinarios/add")
                        .contentType("application/json")
                        .content(
                                objectMapper.writeValueAsString(veterinario)));
        response.andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nombre").value(veterinario.getNombre()))
                .andExpect(jsonPath("$.cedula").value(veterinario.getCedula()))
                .andExpect(jsonPath("$.especialidad").value(veterinario.getEspecialidad()));
    }

    @Test
    public void VeterinarioController_obtenerVeterinarios_ListVeterinario() throws Exception {
        when(veterinarioService.SearchAll()).thenReturn(List.of(
                new Veterinario(
                        "123456789",
                        "Juan Pérez",
                        "1234",
                        "Cirugía",
                        "https://randomuser.me/api/portraits/men/1.jpg"),

                new Veterinario(
                        "123456789",
                        "Juan Pérez",
                        "1234",
                        "Cirugía",
                        "https://randomuser.me/api/portraits/men/1.jpg")

        ));
        ResultActions response = mockMvc.perform(
                get("/veterinarios")
                        .contentType("application/json"));
        response.andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    public void VeterinarioController_obtenerVeterinarioPorId_Veterinario() throws Exception {
        when(veterinarioService.SearchById(anyLong())).thenReturn(
            null
        );

        ResultActions response = mockMvc.perform(
                get("/veterinarios/1")
                        .param("id", "1")
                        .contentType("application/json"));
        response.andExpect(status().isNotFound());
    }
}