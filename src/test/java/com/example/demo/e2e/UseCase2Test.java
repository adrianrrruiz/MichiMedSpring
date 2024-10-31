package com.example.demo.e2e;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UseCase2Test {

  private final String BASE_URL = "http://localhost:4200";

  private WebDriver driver;
  private WebDriverWait wait; // Espera a que ocurra algo en la página para hacer la prueba

  @BeforeEach
  public void setup() {
    // Configuración de WebDriver
    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();

    options.addArguments("--disable-notifications");
    options.addArguments("--disable-extensions");

    this.driver = new ChromeDriver(options);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));// Para que espere máximo 5 segundos

  }

  @Test
  public void SystemTest_Case1_Completed() {
    driver.get(BASE_URL + "/sign-in");

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));

    WebElement inputCedula = driver.findElement(By.id("cedula"));
    WebElement inputContrasena = driver.findElement(By.id("password"));

    inputCedula.sendKeys("123456789");
    inputContrasena.sendKeys("1234");

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));

    WebElement btnIngresar = driver.findElement(By.id("btnIngresar"));
    btnIngresar.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tratamientoNavLink")));

    WebElement tratamientoNavLink = driver.findElement(By.id("tratamientoNavLink"));
    tratamientoNavLink.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mascotas")));

    WebElement mascotas = driver.findElement(By.id("mascotas"));
    mascotas.click();

    


  }

  @AfterEach
  void tearDown() {
    // driver.quit();
  }
}
