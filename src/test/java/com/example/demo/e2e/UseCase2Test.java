package com.example.demo.e2e;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
  public void SystemTest_Case2_Completed() {
    driver.get(BASE_URL + "/sign-in");

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));

    WebElement inputCedula = driver.findElement(By.id("cedula"));
    WebElement inputContrasena = driver.findElement(By.id("password"));

    inputCedula.sendKeys("1052380081");
    inputContrasena.sendKeys("1234");

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));

    WebElement btnIngresar = driver.findElement(By.id("btnIngresar"));
    btnIngresar.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboardNavLink")));

    WebElement tratamientoNavLink = driver.findElement(By.id("dashboardNavLink"));
    tratamientoNavLink.click();

    // Realiza un desplazamiento hacia abajo
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,550)", "");

    // Espera de 3 segundos
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Vuelve a localizar los elementos después del desplazamiento
    WebElement logOutNavLink = driver.findElement(By.id("logOutNavLink"));
    logOutNavLink.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logInButton")));
    WebElement logInButton = driver.findElement(By.id("logInButton"));
    logInButton.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));

    inputCedula = driver.findElement(By.id("cedula"));
    inputContrasena = driver.findElement(By.id("password"));

    inputCedula.sendKeys("123456789");
    inputContrasena.sendKeys("1234");

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));

    btnIngresar = driver.findElement(By.id("btnIngresar"));
    btnIngresar.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tratamientoNavLink")));

    tratamientoNavLink = driver.findElement(By.id("tratamientoNavLink"));
    tratamientoNavLink.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mascotas\"]/div")));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mascotas\"]/div")));

    WebElement inputMascotas = driver.findElement(By.xpath("//*[@id=\"mascotas\"]/div"));
    inputMascotas.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mascotas_list\"]/p-dropdownitem[1]")));
    WebElement dropdownItem = driver.findElement(By.xpath("//*[@id=\"mascotas_list\"]/p-dropdownitem[1]"));
    dropdownItem.click();

    WebElement inputDrogas = driver.findElement(By.xpath("//*[@id=\"pn_id_3\"]/div"));
    inputDrogas.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"pn_id_3_list\"]/p-dropdownitem[1]")));
    WebElement dropdownItemDrogas = driver.findElement(By.xpath("//*[@id=\"pn_id_3_list\"]/p-dropdownitem[1]"));
    dropdownItemDrogas.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSaveTratamiento")));
    WebElement btnSaveTratamiento = driver.findElement(By.id("btnSaveTratamiento"));
    btnSaveTratamiento.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("historialNavLink")));
    logInButton = driver.findElement(By.id("historialNavLink"));
    logInButton.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mascotas")));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mascotas\"]/div")));
    inputMascotas = driver.findElement(By.xpath("//*[@id=\"mascotas\"]/div"));
    inputMascotas.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mascotas_list\"]/p-dropdownitem[1]")));
    dropdownItem = driver.findElement(By.xpath("//*[@id=\"mascotas_list\"]/p-dropdownitem[1]"));
    dropdownItem.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSaveHistorial")));
    btnSaveTratamiento = driver.findElement(By.id("btnSaveHistorial"));
    btnSaveTratamiento.click();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logOutNavLink")));
    logOutNavLink = driver.findElement(By.id("logOutNavLink"));
    logOutNavLink.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logInButton")));
    logInButton = driver.findElement(By.id("logInButton"));
    logInButton.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));

    inputCedula = driver.findElement(By.id("cedula"));
    inputContrasena = driver.findElement(By.id("password"));
    inputCedula.sendKeys("1052380081");
    inputContrasena.sendKeys("1234");
    logInButton = driver.findElement(By.id("btnIngresar"));
    logInButton.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div[3]/app-profit/div/div[1]/div/div[2]/p")));
    js.executeScript("window.scrollBy(0,550)", "");



  }

  @AfterEach
  void tearDown() {
    // driver.quit();
  }
}
