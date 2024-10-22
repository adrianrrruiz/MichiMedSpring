package com.example.demo.repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entidad.Cliente;
import com.example.demo.entidad.Droga;
import com.example.demo.entidad.Mascota;
import com.example.demo.entidad.Tratamiento;
import com.example.demo.entidad.Veterinario;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.repositorio.VeterinarioRepository;
import com.example.demo.repositorio.DrogaRepository;

@DataJpaTest // Crea una base de datos h2 para pruebas
@RunWith(SpringRunner.class) // Permite correr pruebas de Spring
@ActiveProfiles("test")
public class TratamientoRepositoryTest {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private DrogaRepository drogaRepository;

    @BeforeEach // Se ejecuta antes de cada prueba
    public void setUp() {
        mascotaRepository.save(new Mascota("Michito", 3, "angola", 5.3f, "", "En tratamiento", "20/09/18",
                "20/09/18",
                "esomeprazol",
                "https://images.ctfassets.net/denf86kkcx7r/4IPlg4Qazd4sFRuCUHIJ1T/f6c71da7eec727babcd554d843a528b8/gatocomuneuropeo-97?fm=webp&w=612"));
        mascotaRepository.save(new Mascota("Bella", 4, "minecoon", 4.8f, "", "En tratamiento", "15/10/18",
                "20/09/18",
                "esomeprazol",
                "https://urgenciesveterinaries.com/wp-content/uploads/2023/09/survet-gato-caida-pelo-01.jpeg"));
        mascotaRepository.save(new Mascota("Tito", 2, "angola", 3.2f, "", "Tratado", "05/12/18", "20/09/18",
                "esomeprazol",
                "https://cdn.shopify.com/s/files/1/0268/6861/files/Gato-siames-1200x900_480x480.jpg?v=1678812075"));
        mascotaRepository.save(new Mascota("Lucy", 5, "persa", 3.7f, "", "En tratamiento", "10/01/19",
                "20/09/18",
                "esomeprazol",
                "https://www.lapulgada.co/cdn/shop/collections/gato-persa-2_675x675.png?v=1721917322"));
        mascotaRepository.save(new Mascota("Simba", 3, "siames", 4.0f, "", "En tratamiento", "01/02/19",
                "20/09/18",
                "esomeprazol", "https://images.unsplash.com/photo-1518791841217-8f162f1e1131"));

        tratamientoRepository.save(new Tratamiento("05/08/24"));
        tratamientoRepository.save(new Tratamiento("06/08/24"));
        tratamientoRepository.save(new Tratamiento("07/10/24"));
        tratamientoRepository.save(new Tratamiento("08/09/24"));

        // Veterinarios
        veterinarioRepository.save(new Veterinario("123456789", "Juan Pérez", "1234", "Cirugía",
                "https://randomuser.me/api/portraits/men/1.jpg"));
        veterinarioRepository.save(new Veterinario("987654321", "María Gómez", "4321", "Dermatología",
                "https://randomuser.me/api/portraits/women/2.jpg"));
        veterinarioRepository.save(new Veterinario("456789123", "Carlos Díaz", "5678", "Oncología",
                "https://randomuser.me/api/portraits/men/3.jpg"));
        veterinarioRepository.save(new Veterinario("789123456", "Laura Sánchez", "8765", "Cardiología",
                "https://randomuser.me/api/portraits/women/4.jpg"));
        veterinarioRepository.save(new Veterinario("321654987", "Lucía Martínez", "6789", "Gastroenterología",
                "https://randomuser.me/api/portraits/women/6.jpg"));

        // Drogas
        drogaRepository.save(new Droga("esomeprazol", 120000.0, 150000.0, 8, 0));
        drogaRepository.save(new Droga("paracetamol", 100000.0, 130000.0, 7, 0));
        drogaRepository.save(new Droga("ibuprofeno", 80000.0, 110000.0, 6, 0));
        drogaRepository.save(new Droga("amoxicilina", 60000.0, 90000.0, 5, 0));
        drogaRepository.save(new Droga("dexametasona", 40000.0, 70000.0, 4, 0));

        // Clientes
        clienteRepository.save(new Cliente("123456789", "Juan Perez", "juan@gmail.com", "1234"));
        clienteRepository.save(new Cliente("987654321", "Maria Lopez", "maria@gmail.com", "4321"));
        clienteRepository.save(new Cliente("456789123", "Pedro Ramirez", "pedro@gmail.com", "5678"));
        clienteRepository.save(new Cliente("789123456", "Ana Rodriguez", "ana@gmail.com", "8765"));
        clienteRepository.save(new Cliente("223456789", "Carlos Gomez", "carlos@gmail.com", "abcd"));
        clienteRepository.save(new Cliente("112345678", "Laura Martinez", "laura@gmail.com", "qwer"));

        // Obtener todas las mascotas y clientes
        List<Mascota> mascotas = mascotaRepository.findAll();
        List<Cliente> clientes = clienteRepository.findAll();

        // Verificar que las listas no estén vacías
        if (mascotas.isEmpty() || clientes.isEmpty()) {
            throw new RuntimeException("No se encontraron mascotas o clientes en la base de datos");
        }

        // Mezclar las listas para asegurar la aleatoriedad
        Collections.shuffle(mascotas);
        Collections.shuffle(clientes);

        // Asignar mascotas a clientes de forma cíclica
        int numClientes = clientes.size();
        for (int i = 0; i < mascotas.size(); i++) {
            Mascota mascota = mascotas.get(i);
            Cliente cliente = clientes.get(i % numClientes);
            mascota.setCliente(cliente);
            mascotaRepository.save(mascota);
        }

        // Obtener todas las veterinarios y tratamientos
        List<Veterinario> veterinarios = veterinarioRepository.findAll();
        List<Tratamiento> tratamientos = tratamientoRepository.findAll();

        // Verificar que las listas no estén vacías
        if (veterinarios.isEmpty() || tratamientos.isEmpty()) {
            throw new RuntimeException("No se encontraron veterinarios o tratamientos en la base de datos");
        }

        int CANTIDAD_VETERINARIOS = veterinarios.size();
        int CANTIDAD_MASCOTAS = mascotas.size();

        // Asignar tratamientos a veterinarios y mascotas
        for (Tratamiento tratamiento : tratamientos) {
            int id_veterinario = ThreadLocalRandom.current().nextInt(CANTIDAD_VETERINARIOS);
            int id_mascota = ThreadLocalRandom.current().nextInt(CANTIDAD_MASCOTAS);

            Veterinario veterinario = veterinarios.get(id_veterinario);
            Mascota mascota = mascotas.get(id_mascota);

            tratamiento.setVeterinario(veterinario);
            tratamiento.setMascota(mascota);
            tratamientoRepository.save(tratamiento); // Guardar el tratamiento actualizado
        }

        // Obtener todas las drogas
        List<Droga> drogas = drogaRepository.findAll();

        // Verificar que la lista no esté vacía
        if (drogas.isEmpty()) {
            throw new RuntimeException("No se encontraron drogas en la base de datos");
        }

        // Mezclar las listas para asegurar la aleatoriedad
        Collections.shuffle(tratamientos);
        Collections.shuffle(drogas);

        // Asignar tratamientos a drogas de forma cíclica
        int CANTIDAD_DROGAS = drogas.size();
        for (int i = 0; i < tratamientos.size(); i++) {
            Tratamiento tratamiento = tratamientos.get(i);
            Droga droga = drogas.get(i % CANTIDAD_DROGAS);
            if (droga.getUniDisp() == 0) {
                i--;
                continue;
            }
            droga.setUniDisp(droga.getUniDisp() - 1);
            droga.setUniVend(droga.getUniVend() + 1);
            tratamiento.setDroga(droga);
            tratamientoRepository.save(tratamiento);
        }
    }

    @Test
    public void testContarTratamientosPorMes() {
        List<Map<String, Object>> resultado = tratamientoRepository.contarTratamientosPorMes();
        Assertions.assertThat(resultado).isNotNull();
        Assertions.assertThat(resultado.size()).isEqualTo(3);

        Map<String, Object> agosto2024 = resultado.stream().filter(map -> map.get("mes").equals("agosto 2024")).findFirst().orElse(null);
        Map<String, Object> septiembre2024 = resultado.stream().filter(map -> map.get("mes").equals("septiembre 2024")).findFirst().orElse(null);
        Map<String, Object> octubre2024 = resultado.stream().filter(map -> map.get("mes").equals("octubre 2024")).findFirst().orElse(null);

        Assertions.assertThat(agosto2024).isNotNull();
        Assertions.assertThat(agosto2024.get("cantidad")).isEqualTo(2L);

        Assertions.assertThat(septiembre2024).isNotNull();
        Assertions.assertThat(septiembre2024.get("cantidad")).isEqualTo(1L);

        Assertions.assertThat(octubre2024).isNotNull();
        Assertions.assertThat(octubre2024.get("cantidad")).isEqualTo(1L);
    }


    @Test
    public void testFindTopVeterinariosByDroga() {
        List<Map<String, Object>> resultado = tratamientoRepository.findTopVeterinariosByDroga();
        Assertions.assertThat(resultado).isNotNull();
        Assertions.assertThat(resultado.size()).isEqualTo(3);

        Map<String, Object> top1 = resultado.get(0);
        Map<String, Object> top2 = resultado.get(1);
        Map<String, Object> top3 = resultado.get(2);

        // Verificar que los resultados no sean nulos
        Assertions.assertThat(top1).isNotNull();
        Assertions.assertThat(top2).isNotNull();
        Assertions.assertThat(top3).isNotNull();

        // Imprimir los resultados para verificar manualmente
        System.out.println("Top 1: " + top1);
        System.out.println("Top 2: " + top2);
        System.out.println("Top 3: " + top3);
    }

    //Veterinarios
    @Test
    public void testObtenerEstadisticasVeterinarios() {
        Map<String, Long> resultado = veterinarioRepository.obtenerEstadisticasVeterinarios();
        Assertions.assertThat(resultado).isNotNull();
        Assertions.assertThat(resultado.get("total_veterinarios")).isEqualTo(5L);
        Assertions.assertThat(resultado.get("veterinarios_activos")).isEqualTo(3L);
    }

    @Test
    public void testFindByCedula() {
        Optional<Veterinario> veterinario = veterinarioRepository.findByCedula("123456789");
        Assertions.assertThat(veterinario).isPresent();
        Assertions.assertThat(veterinario.get().getNombre()).isEqualTo("Juan Pérez");

        veterinario = veterinarioRepository.findByCedula("987654321");
        Assertions.assertThat(veterinario).isPresent();
        Assertions.assertThat(veterinario.get().getNombre()).isEqualTo("María Gómez");

        veterinario = veterinarioRepository.findByCedula("000000000");
        Assertions.assertThat(veterinario).isNotPresent();
    }
}
