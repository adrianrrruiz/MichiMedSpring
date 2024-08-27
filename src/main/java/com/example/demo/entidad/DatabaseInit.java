package com.example.demo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        mascotaRepository.save(new Mascota("Michito", 3, "angola", 5.3f, "", "En tratamiento", "20/09/18", "20/09/18",
        "esomeprazol","https://images.ctfassets.net/denf86kkcx7r/4IPlg4Qazd4sFRuCUHIJ1T/f6c71da7eec727babcd554d843a528b8/gatocomuneuropeo-97?fm=webp&w=612"));
        mascotaRepository.save(new Mascota("Bella", 4, "minecoon", 4.8f, "", "En tratamiento", "15/10/18", "20/09/18",
                "esomeprazol", "https://urgenciesveterinaries.com/wp-content/uploads/2023/09/survet-gato-caida-pelo-01.jpeg"));
        mascotaRepository.save(new Mascota("Tito", 2, "angola", 3.2f, "", "Tratado", "05/12/18", "20/09/18",
                "esomeprazol", "https://cdn.shopify.com/s/files/1/0268/6861/files/Gato-siames-1200x900_480x480.jpg?v=1678812075"));
        mascotaRepository.save(new Mascota("Lucy", 5, "persa", 3.7f, "", "En tratamiento", "10/01/19", "20/09/18",
                "esomeprazol", "https://www.lapulgada.co/cdn/shop/collections/gato-persa-2_675x675.png?v=1721917322"));
    
        clienteRepository.save(new Cliente("123456789", "Juan Perez", "juan@gmail.com", "1234"));
        clienteRepository.save(new Cliente("987654321", "Maria Lopez", "maria@gmail.com", "4321"));
        clienteRepository.save(new Cliente("456789123", "Pedro Ramirez", "pedro@gmail.com", "5678"));
        clienteRepository.save(new Cliente("789123456", "Ana Rodriguez", "ana@gmail.com", "8765"));

        //Asociando todas las mascotas al cliente con id 1
        Cliente cliente = clienteRepository.findById(1L).get();
        for (Mascota mascota : mascotaRepository.findAll()) {
          mascota.setCliente(cliente);
          mascotaRepository.save(mascota);
        }
    }

}
