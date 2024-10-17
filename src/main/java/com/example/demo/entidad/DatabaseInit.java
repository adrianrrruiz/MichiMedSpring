package com.example.demo.entidad;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.AdministradorRepository;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.DrogaRepository;
import com.example.demo.repositorio.MascotaRepository;
import com.example.demo.repositorio.TratamientoRepository;
import com.example.demo.repositorio.VeterinarioRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

        @Autowired
        AdministradorRepository administradorRepository;

        @Autowired
        MascotaRepository mascotaRepository;

        @Autowired
        ClienteRepository clienteRepository;

        @Autowired
        VeterinarioRepository veterinarioRepository;

        @Autowired
        DrogaRepository drogaRepository;

        @Autowired
        TratamientoRepository tratamientoRepository;

        @Override
        public void run(ApplicationArguments args) throws Exception {

                administradorRepository.save(new Administrador("1014977178", "Adrian Ruiz", "1234"));
                administradorRepository.save(new Administrador("1052380081", "Carlos Mejía", "1234"));
                administradorRepository.save(new Administrador("1010961264", "Juan Pablo", "1234"));
                administradorRepository.save(new Administrador("123", "Juan Angarita", "1234"));

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
                mascotaRepository.save(new Mascota("Nala", 2, "maine coon", 6.1f, "", "Tratado", "03/03/19", "20/09/18",
                                "esomeprazol",
                                "https://cdn.pixabay.com/photo/2017/11/09/21/41/cat-2934720_960_720.jpg"));
                mascotaRepository.save(new Mascota("Max", 1, "angora", 4.5f, "", "En tratamiento", "04/04/19",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1673461703605-0c6cc77e1a35?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Z2F0b3xlbnwwfHwwfHx8MA%3D%3D"));
                mascotaRepository.save(new Mascota("Milo", 4, "siames", 3.9f, "", "En tratamiento", "05/05/19",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8Z2F0b3xlbnwwfHwwfHx8MA%3D%3D"));
                mascotaRepository.save(new Mascota("Leo", 3, "persa", 5.2f, "", "Tratado", "06/06/19", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1677545183884-421157b2da02?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8Z2F0b3xlbnwwfHwwfHx8MA%3D%3D"));
                mascotaRepository.save(new Mascota("Luna", 2, "maine coon", 4.7f, "", "En tratamiento", "07/07/19",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1664299749481-ac8dc8b49754?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8Z2F0b3xlbnwwfHwwfHx8MA%3D%3D"));
                mascotaRepository.save(new Mascota("Rocky", 5, "angora", 5.0f, "", "En tratamiento", "08/08/19",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1501820488136-72669149e0d4?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8Z2F0b3xlbnwwfHwwfHx8MA%3D%3D"));
                mascotaRepository.save(new Mascota("Zoe", 4, "siames", 3.8f, "", "Tratado", "09/09/19", "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1571566882372-1598d88abd90?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Charlie", 3, "persa", 4.6f, "", "En tratamiento", "10/10/19",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1667030474693-6d0632f97029?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Chloe", 2, "maine coon", 4.9f, "", "Tratado", "11/11/19",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1503777119540-ce54b422baff?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Lily", 1, "angora", 3.6f, "", "En tratamiento", "12/12/19",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1573865526739-10659fec78a5?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Oscar", 5, "siames", 5.1f, "", "En tratamiento", "13/01/20",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1677545182067-26ac518ef64f?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Toby", 4, "persa", 4.2f, "", "Tratado", "14/02/20", "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1513360371669-4adf3dd7dff8?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Molly", 3, "maine coon", 4.4f, "", "En tratamiento", "15/03/20",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1573865526739-10659fec78a5?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Daisy", 2, "angora", 3.5f, "", "En tratamiento", "16/04/20",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1506755855567-92ff770e8d00?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Ruby", 1, "siames", 4.3f, "", "Tratado", "17/05/20", "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1495360010541-f48722b34f7d?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Felix", 5, "persa", 5.0f, "", "En tratamiento", "18/06/20",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1495360010541-f48722b34f7d?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Oliver", 4, "maine coon", 3.7f, "", "Tratado", "19/07/20",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1516139008210-96e45dccd83b?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTh8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Jasper", 3, "angora", 4.8f, "", "En tratamiento", "20/08/20",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1518288774672-b94e808873ff?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjJ8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Smokey", 2, "siames", 4.1f, "", "Tratado", "21/09/20", "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1513245543132-31f507417b26?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjN8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Misty", 1, "persa", 4.9f, "", "En tratamiento", "22/10/20",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1493406300581-484b937cdc41?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Gizmo", 5, "maine coon", 5.4f, "", "Tratado", "23/11/20",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1533743983669-94fa5c4338ec?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjR8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Cleo", 4, "angora", 4.0f, "", "En tratamiento", "24/12/20",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1491833485966-73cfb9ccea53?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjZ8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Pepper", 3, "siames", 3.9f, "", "Tratado", "25/01/21", "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1491833485966-73cfb9ccea53?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjZ8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Shadow", 2, "persa", 5.2f, "", "En tratamiento", "26/02/21",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1568152950566-c1bf43f4ab28?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjd8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Whiskers", 1, "maine coon", 4.7f, "", "Tratado", "27/03/21",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1677545182425-4fb12bdb9faf?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjV8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Coco", 5, "angora", 4.1f, "", "En tratamiento", "28/04/21",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1475518112798-86ae358241eb?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Simba", 4, "siames", 5.3f, "", "Tratado", "29/05/21", "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzB8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Nala", 3, "persa", 4.6f, "", "En tratamiento", "30/06/21",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1517451330947-7809dead78d5?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjh8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Max", 2, "maine coon", 5.0f, "", "Tratado", "01/07/21", "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1502083896352-259ab9e342d7?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzZ8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Milo", 1, "angora", 3.8f, "", "En tratamiento", "02/08/21",
                                "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1498100152307-ce63fd6c5424?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzJ8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Leo", 5, "siames", 4.9f, "", "Tratado", "03/09/21", "20/09/18",
                                "esomeprazol",
                                "https://images.unsplash.com/photo-1515002246390-7bf7e8f87b54?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mzh8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Luna", 4, "persa", 4.3f, "", "En tratamiento", "04/10/21",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Rocky", 3, "maine coon", 4.5f, "", "Tratado", "05/11/21",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Zoe", 2, "angora", 4.2f, "", "En tratamiento", "06/12/21",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Simba", 1, "siames", 3.7f, "", "Tratado", "07/01/22", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Bella", 5, "persa", 5.1f, "", "En tratamiento", "08/02/22",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Tito", 4, "maine coon", 4.4f, "", "Tratado", "09/03/22", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Lucy", 3, "angora", 3.9f, "", "En tratamiento", "10/04/22",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Charlie", 2, "siames", 4.8f, "", "Tratado", "11/05/22", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Chloe", 1, "persa", 4.0f, "", "En tratamiento", "12/06/22",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Lily", 5, "maine coon", 4.7f, "", "Tratado", "13/07/22", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Oscar", 4, "angora", 3.6f, "", "En tratamiento", "14/08/22",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Toby", 3, "siames", 5.2f, "", "Tratado", "15/09/22", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Molly", 2, "persa", 4.1f, "", "En tratamiento", "16/10/22",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Daisy", 1, "maine coon", 4.9f, "", "Tratado", "17/11/22",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Ruby", 5, "angora", 3.5f, "", "En tratamiento", "18/12/22",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Felix", 4, "siames", 5.3f, "", "Tratado", "19/01/23", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Oliver", 3, "persa", 4.4f, "", "En tratamiento", "20/02/23",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Jasper", 2, "maine coon", 4.0f, "", "Tratado", "21/03/23",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Smokey", 1, "angora", 5.2f, "", "En tratamiento", "22/04/23",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Misty", 5, "siames", 4.3f, "", "Tratado", "23/05/23", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Gizmo", 4, "persa", 4.5f, "", "En tratamiento", "24/06/23",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Cleo", 3, "maine coon", 3.7f, "", "Tratado", "25/07/23", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Pepper", 2, "angora", 4.6f, "", "En tratamiento", "26/08/23",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Shadow", 1, "siames", 4.0f, "", "Tratado", "27/09/23", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Whiskers", 5, "persa", 3.8f, "", "En tratamiento", "28/10/23",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Coco", 4, "maine coon", 5.1f, "", "Tratado", "29/11/23", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Max", 5, "maine coon", 4.2f, "", "Tratado", "30/07/23", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Milo", 4, "angora", 3.9f, "", "En tratamiento", "31/08/23",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Leo", 3, "siames", 4.7f, "", "Tratado", "01/09/23", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Luna", 2, "persa", 4.0f, "", "En tratamiento", "02/10/23",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Rocky", 1, "maine coon", 4.8f, "", "Tratado", "03/11/23",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Zoe", 5, "angora", 3.7f, "", "En tratamiento", "04/12/23",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Simba", 4, "siames", 5.0f, "", "Tratado", "05/01/24", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Nala", 3, "persa", 4.4f, "", "En tratamiento", "06/02/24",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Max", 2, "maine coon", 3.8f, "", "Tratado", "07/03/24", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Milo", 1, "angora", 4.9f, "", "En tratamiento", "08/04/24",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Leo", 5, "siames", 4.3f, "", "Tratado", "09/05/24", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Luna", 4, "persa", 4.6f, "", "En tratamiento", "10/06/24",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Rocky", 3, "maine coon", 4.1f, "", "Tratado", "11/07/24",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Zoe", 2, "angora", 5.3f, "", "En tratamiento", "12/08/24",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Simba", 1, "siames", 4.5f, "", "Tratado", "13/09/24", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Nala", 5, "persa", 3.6f, "", "En tratamiento", "14/10/24",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Max", 4, "maine coon", 5.1f, "", "Tratado", "15/11/24", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Milo", 3, "angora", 4.2f, "", "En tratamiento", "16/12/24",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Leo", 2, "siames", 4.7f, "", "Tratado", "17/01/25", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Luna", 1, "persa", 3.9f, "", "En tratamiento", "18/02/25",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Rocky", 5, "maine coon", 5.2f, "", "Tratado", "19/03/25",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Zoe", 4, "angora", 4.4f, "", "En tratamiento", "20/04/25",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Simba", 3, "siames", 3.5f, "", "Tratado", "21/05/25", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Nala", 2, "persa", 4.8f, "", "En tratamiento", "22/06/25",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Max", 1, "maine coon", 4.0f, "", "Tratado", "23/07/25", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Milo", 5, "angora", 4.5f, "", "En tratamiento", "24/08/25",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Leo", 4, "siames", 3.7f, "", "Tratado", "25/09/25", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Luna", 3, "persa", 4.9f, "", "En tratamiento", "26/10/25",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Rocky", 2, "maine coon", 4.1f, "", "Tratado", "27/11/25",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Zoe", 1, "angora", 5.0f, "", "En tratamiento", "28/12/25",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Simba", 5, "siames", 4.3f, "", "Tratado", "29/01/26", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Nala", 4, "persa", 3.8f, "", "En tratamiento", "30/02/26",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Max", 3, "maine coon", 4.6f, "", "Tratado", "31/03/26", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Milo", 2, "angora", 4.4f, "", "En tratamiento", "01/04/26",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Leo", 1, "siames", 3.6f, "", "Tratado", "02/05/26", "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Luna", 5, "persa", 4.5f, "", "En tratamiento", "03/06/26",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Rocky", 4, "maine coon", 3.9f, "", "Tratado", "04/07/26",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));
                mascotaRepository.save(new Mascota("Zoe", 3, "angora", 4.7f, "", "En tratamiento", "05/08/26",
                                "20/09/18",
                                "esomeprazol",
                                "https://plus.unsplash.com/premium_photo-1661674514856-17f29bd480b6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fGdhdG98ZW58MHx8MHx8fDA%3D"));

                // 50 Clientes
                clienteRepository.save(new Cliente("123456789", "Juan Perez", "juan@gmail.com", "1234"));
                clienteRepository.save(new Cliente("987654321", "Maria Lopez", "maria@gmail.com", "4321"));
                clienteRepository.save(new Cliente("456789123", "Pedro Ramirez", "pedro@gmail.com", "5678"));
                clienteRepository.save(new Cliente("789123456", "Ana Rodriguez", "ana@gmail.com", "8765"));
                clienteRepository.save(new Cliente("223456789", "Carlos Gomez", "carlos@gmail.com", "abcd"));
                clienteRepository.save(new Cliente("112345678", "Laura Martinez", "laura@gmail.com", "qwer"));
                clienteRepository.save(new Cliente("998877665", "Luis Torres", "luis@gmail.com", "zxcv"));
                clienteRepository.save(new Cliente("887766554", "Sara Gutierrez", "sara@gmail.com", "asdf"));
                clienteRepository.save(new Cliente("776655443", "Miguel Jimenez", "miguel@gmail.com", "ghjk"));
                clienteRepository.save(new Cliente("665544332", "Carmen Ortiz", "carmen@gmail.com", "tyui"));
                clienteRepository.save(new Cliente("554433221", "Jorge Vargas", "jorge@gmail.com", "bnmv"));
                clienteRepository.save(new Cliente("443322110", "Diana Lopez", "diana@gmail.com", "lmno"));
                clienteRepository.save(new Cliente("332211009", "Fernando Suarez", "fernando@gmail.com", "pqrs"));
                clienteRepository.save(new Cliente("221100998", "Patricia Rios", "patricia@gmail.com", "uvwx"));
                clienteRepository.save(new Cliente("110099887", "Roberto Morales", "roberto@gmail.com", "yzab"));
                clienteRepository.save(new Cliente("109876543", "Silvia Marquez", "silvia@gmail.com", "cdef"));
                clienteRepository.save(new Cliente("209876543", "Emilio Perez", "emilio@gmail.com", "ghij"));
                clienteRepository.save(new Cliente("309876543", "Paola Rodriguez", "paola@gmail.com", "klmn"));
                clienteRepository.save(new Cliente("409876543", "Ricardo Diaz", "ricardo@gmail.com", "opqr"));
                clienteRepository.save(new Cliente("509876543", "Andrea Ruiz", "andrea@gmail.com", "stuv"));
                clienteRepository.save(new Cliente("609876543", "Javier Sanchez", "javier@gmail.com", "wxyz"));
                clienteRepository.save(new Cliente("709876543", "Gloria Paredes", "gloria@gmail.com", "abcd"));
                clienteRepository.save(new Cliente("809876543", "Oscar Ramirez", "oscar@gmail.com", "efgh"));
                clienteRepository.save(new Cliente("909876543", "Angela Flores", "angela@gmail.com", "ijkl"));
                clienteRepository.save(new Cliente("1009876543", "Mario Rivera", "mario@gmail.com", "mnop"));
                clienteRepository.save(new Cliente("2009876543", "Gabriela Soto", "gabriela@gmail.com", "qrst"));
                clienteRepository.save(new Cliente("3009876543", "Adrian Gil", "adrian@gmail.com", "uvwx"));
                clienteRepository.save(new Cliente("4009876543", "Rosa Castillo", "rosa@gmail.com", "yzab"));
                clienteRepository.save(new Cliente("5009876543", "Raul Guerrero", "raul@gmail.com", "cdef"));
                clienteRepository.save(new Cliente("6009876543", "Claudia Herrera", "claudia@gmail.com", "ghij"));
                clienteRepository.save(new Cliente("7009876543", "Nicolas Medina", "nicolas@gmail.com", "klmn"));
                clienteRepository.save(new Cliente("8009876543", "Isabel Morales", "isabel@gmail.com", "opqr"));
                clienteRepository.save(new Cliente("9009876543", "Eduardo Vega", "eduardo@gmail.com", "stuv"));
                clienteRepository.save(new Cliente("1010987654", "Natalia Jimenez", "natalia@gmail.com", "wxyz"));
                clienteRepository.save(new Cliente("1110987654", "David Castillo", "david@gmail.com", "abcd"));
                clienteRepository.save(new Cliente("1210987654", "Valentina Ruiz", "valentina@gmail.com", "efgh"));
                clienteRepository.save(new Cliente("1310987654", "Pablo Vasquez", "pablo@gmail.com", "ijkl"));
                clienteRepository.save(new Cliente("1410987654", "Veronica Ponce", "veronica@gmail.com", "mnop"));
                clienteRepository.save(new Cliente("1510987654", "Manuel Ortega", "manuel@gmail.com", "qrst"));
                clienteRepository.save(new Cliente("1610987654", "Ines Cruz", "ines@gmail.com", "uvwx"));
                clienteRepository.save(new Cliente("1710987654", "Esteban Mendez", "esteban@gmail.com", "yzab"));
                clienteRepository.save(new Cliente("1810987654", "Alejandra Mora", "alejandra@gmail.com", "cdef"));
                clienteRepository.save(new Cliente("1910987654", "Carlos Valle", "carlosv@gmail.com", "ghij"));
                clienteRepository.save(new Cliente("2010987654", "Lucia Castro", "lucia@gmail.com", "klmn"));
                clienteRepository.save(new Cliente("2110987654", "Alberto Ruiz", "alberto@gmail.com", "opqr"));
                clienteRepository.save(new Cliente("2210987654", "Beatriz Peña", "beatriz@gmail.com", "stuv"));
                clienteRepository.save(new Cliente("2310987654", "Julio Arias", "julio@gmail.com", "wxyz"));
                clienteRepository.save(new Cliente("2410987654", "Lorena Fuentes", "lorena@gmail.com", "abcd"));
                clienteRepository.save(new Cliente("2510987654", "Hugo Rojas", "hugo@gmail.com", "efgh"));
                clienteRepository.save(new Cliente("2610987654", "Monica Salazar", "monica@gmail.com", "ijkl"));

                // Veterinarios
                veterinarioRepository.save(new Veterinario("123456789", "Juan Pérez", "1234", "Cirugía",
                                "https://randomuser.me/api/portraits/men/1.jpg"));
                veterinarioRepository.save(new Veterinario("987654321", "María Gómez", "4321", "Dermatología",
                                "https://randomuser.me/api/portraits/women/2.jpg"));
                veterinarioRepository.save(new Veterinario("456789123", "Carlos Díaz", "5678", "Oncología",
                                "https://randomuser.me/api/portraits/men/3.jpg"));
                veterinarioRepository.save(new Veterinario("789123456", "Laura Sánchez", "8765", "Cardiología",
                                "https://randomuser.me/api/portraits/women/4.jpg"));
                veterinarioRepository.save(new Veterinario("654321987", "Pedro Ramírez", "3456", "Neurología",
                                "https://randomuser.me/api/portraits/men/5.jpg"));
                veterinarioRepository.save(new Veterinario("321654987", "Lucía Martínez", "6789", "Gastroenterología",
                                "https://randomuser.me/api/portraits/women/6.jpg"));
                veterinarioRepository.save(new Veterinario("456123789", "Andrés Torres", "7890", "Oftalmología",
                                "https://randomuser.me/api/portraits/men/7.jpg"));
                veterinarioRepository.save(new Veterinario("789654123", "Elena González", "8901", "Ortopedia",
                                "https://randomuser.me/api/portraits/women/8.jpg"));
                veterinarioRepository.save(new Veterinario("147852369", "Sofía Ruiz", "9012", "Pediatría",
                                "https://randomuser.me/api/portraits/women/9.jpg"));
                veterinarioRepository.save(new Veterinario("963852741", "Roberto Morales", "2345", "Urología",
                                "https://randomuser.me/api/portraits/men/10.jpg"));
                veterinarioRepository.save(new Veterinario("258369147", "Adriana Castro", "3456", "Endocrinología",
                                "https://randomuser.me/api/portraits/women/11.jpg"));
                veterinarioRepository.save(new Veterinario("147963258", "Gabriel Fernández", "4567", "Neumología",
                                "https://randomuser.me/api/portraits/men/12.jpg"));
                veterinarioRepository.save(new Veterinario("852741963", "Patricia Herrera", "5678", "Hematología",
                                "https://randomuser.me/api/portraits/women/13.jpg"));
                veterinarioRepository.save(new Veterinario("369258147", "Ricardo Silva", "6789", "Dermatología",
                                "https://randomuser.me/api/portraits/men/14.jpg"));
                veterinarioRepository.save(new Veterinario("753159852", "Martín López", "7890", "Reumatología",
                                "https://randomuser.me/api/portraits/men/15.jpg"));
                veterinarioRepository.save(new Veterinario("951753258", "Alicia Vega", "8901", "Oncología",
                                "https://randomuser.me/api/portraits/women/16.jpg"));
                veterinarioRepository.save(new Veterinario("159753486", "Natalia Ramos", "9123", "Nefrología",
                                "https://randomuser.me/api/portraits/women/17.jpg"));
                veterinarioRepository.save(new Veterinario("753486159", "Eduardo Pérez", "1239", "Psiquiatría",
                                "https://randomuser.me/api/portraits/men/18.jpg"));
                veterinarioRepository.save(new Veterinario("486159753", "Isabel Morales", "1345", "Inmunología",
                                "https://randomuser.me/api/portraits/women/19.jpg"));
                veterinarioRepository.save(new Veterinario("975318642", "Fernando Castro", "4561", "Infectología",
                                "https://randomuser.me/api/portraits/men/20.jpg"));
                veterinarioRepository.save(new Veterinario("753864159", "Paola Medina", "5612", "Geriatría",
                                "https://randomuser.me/api/portraits/women/21.jpg"));

                // Crear y guardar Tratamientos con relaciones
                tratamientoRepository.save(new Tratamiento("05/08/26"));
                tratamientoRepository.save(new Tratamiento("06/08/26"));
                tratamientoRepository.save(new Tratamiento("07/08/26"));
                tratamientoRepository.save(new Tratamiento("08/08/26"));
                tratamientoRepository.save(new Tratamiento("09/08/26"));
                tratamientoRepository.save(new Tratamiento("10/08/26"));
                tratamientoRepository.save(new Tratamiento("11/08/26"));
                tratamientoRepository.save(new Tratamiento("12/08/26"));
                tratamientoRepository.save(new Tratamiento("13/08/26"));
                tratamientoRepository.save(new Tratamiento("14/08/26"));
                tratamientoRepository.save(new Tratamiento("14/06/26"));
                tratamientoRepository.save(new Tratamiento("12/06/26"));
                tratamientoRepository.save(new Tratamiento("12/06/26"));
                tratamientoRepository.save(new Tratamiento("12/06/26"));
                tratamientoRepository.save(new Tratamiento("12/06/26"));
                tratamientoRepository.save(new Tratamiento("12/05/26"));
                tratamientoRepository.save(new Tratamiento("12/05/26"));
                tratamientoRepository.save(new Tratamiento("12/05/26"));
                tratamientoRepository.save(new Tratamiento("12/05/26"));

                // Drogas
                drogaRepository.save(new Droga("esomeprazol", 120000.0, 150000.0, 8, 0));
                drogaRepository.save(new Droga("paracetamol", 100000.0, 130000.0, 7, 0));
                drogaRepository.save(new Droga("ibuprofeno", 80000.0, 110000.0, 6, 0));
                drogaRepository.save(new Droga("amoxicilina", 60000.0, 90000.0, 5, 0));
                drogaRepository.save(new Droga("dexametasona", 40000.0, 70000.0, 4, 0));

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

                Long mascotaId = 1L; // El id de la mascota que quieres asociar
                Long veterinarioId = 2L; // El id del veterinario que quieres asociar

                // Ahora los usas para obtener la mascota y el veterinario desde la base de
                // datos
                Mascota mascota = mascotaRepository.findById(mascotaId)
                                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
                Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));

                // Crear un tratamiento y asignar la mascota y el veterinario
                Tratamiento tratamiento = new Tratamiento("05/08/26", mascota, veterinario);
                tratamientoRepository.save(tratamiento);

        }

}
