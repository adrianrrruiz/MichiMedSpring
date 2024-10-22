package com.example.demo.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.servicio.MascotaServiceInterface;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class MascotaServiceTest {

  @Autowired
  private MascotaServiceInterface mascotaService;

}
