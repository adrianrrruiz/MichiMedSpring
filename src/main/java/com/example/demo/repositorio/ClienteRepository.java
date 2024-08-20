package com.example.demo.repositorio;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Cliente;

@Repository
public class ClienteRepository {

    private Map<Integer, Cliente> clientes = new HashMap<>();

    public ClienteRepository() {
        clientes.put(1, new Cliente("123456789", "Juan Perez", "juan@gmail.com", "1234"));
        clientes.put(2, new Cliente("987654321", "Maria Lopez", "maria@gmail.com", "4321"));
        clientes.put(3, new Cliente("456789123", "Pedro Ramirez", "pedro@gmail.com", "5678"));
        clientes.put(4, new Cliente("789123456", "Ana Rodriguez", "ana@gmail.com", "8765"));
    }

    public Cliente getClienteById(int id) {
        return clientes.get(id);
    }

    public Cliente getClienteByEmail(String email) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getCorreo().equals(email)) {
                return cliente;
            }
        }
        return null;
    }

    public Collection<Cliente> findAll() {
        return clientes.values();
    }
}
