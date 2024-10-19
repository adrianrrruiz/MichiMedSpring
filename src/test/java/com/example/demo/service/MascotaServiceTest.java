package com.example.demo.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.servicio.MascotaServiceInterface;

@ExtendWith(MockitoExtension.class)
public class MascotaServiceTest {

  @Autowired
  private MascotaServiceInterface mascotaService;

}
