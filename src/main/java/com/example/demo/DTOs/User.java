package com.example.demo.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String cedula;
    private String password;

    public User(String cedula, String password) {
        this.cedula = cedula;
        this.password = password;
    }
}
