package com.example.demo.e2e;

import java.time.Duration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
public class UseCase1Test {

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
    // Abre la página de inicio de sesión.
    driver.get(BASE_URL + "/sign-in");

    // Espera que los campos de 'cedula' y 'password' estén presentes en la página.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));

    // Localiza los campos de entrada para cédula y contraseña.
    WebElement inputCedula = driver.findElement(By.id("cedula"));
    WebElement inputContrasena = driver.findElement(By.id("password"));

    // Ingresa una cédula y contraseña no válidos.
    inputCedula.sendKeys("987654");
    inputContrasena.sendKeys("4321");

    // Espera y localiza el botón de ingresar y realiza clic en él.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
    WebElement btnIngresar = driver.findElement(By.id("btnIngresar"));
    btnIngresar.click();

    // Limpia los campos y vuelve a ingresar credenciales válidas.
    inputCedula.clear();
    inputContrasena.clear();
    inputCedula.sendKeys("987654321");
    inputContrasena.sendKeys("4321");
    btnIngresar.click();

    // Espera que el enlace de cliente esté presente y realiza clic para navegar a
    // la página de clientes.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("clienteNavLink")));
    WebElement clienteNavLink = driver.findElement(By.id("clienteNavLink"));
    clienteNavLink.click();

    // Espera el botón para agregar un nuevo cliente y hace clic en él.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnNewCliente")));
    WebElement btnNewCliente = driver.findElement(By.id("btnNewCliente"));
    btnNewCliente.click();

    // Espera los campos de información de cliente.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nombre")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

    // Rellena el formulario con los datos del cliente.
    WebElement inputNombre = driver.findElement(By.id("nombre"));
    WebElement inputCedulaCliente = driver.findElement(By.id("cedula"));
    WebElement inputEmail = driver.findElement(By.id("email"));
    inputNombre.sendKeys("Cliente prueba");
    inputCedulaCliente.sendKeys("456123");
    inputEmail.sendKeys("");

    // Intenta guardar el cliente sin correo electrónico (falla esperada).
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSaveCliente")));
    WebElement btnSaveCliente = driver.findElement(By.id("btnSaveCliente"));
    btnSaveCliente.click();

    // Rellena el campo de correo electrónico y guarda el cliente.
    inputEmail.clear();
    inputEmail.sendKeys("cliente@gmail.com");
    btnSaveCliente.click();

    // Navega a la página de mascotas.
    WebElement mascotaNavLink = driver.findElement(By.id("mascotaNavLink"));
    mascotaNavLink.click();

    // Espera y selecciona el botón para agregar una nueva mascota.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnNewMascota")));
    WebElement btnNewMascota = driver.findElement(By.id("btnNewMascota"));
    btnNewMascota.click();

    // Espera los campos de información de mascota.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nombre")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("raza")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("edad")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("peso")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("enfermedad")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("estado")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("foto")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("clientes")));

    // Completa el formulario de la mascota.
    WebElement inputNombreMascota = driver.findElement(By.id("nombre"));
    WebElement inputRaza = driver.findElement(By.id("raza"));
    WebElement inputEdad = driver.findElement(By.id("edad"));
    WebElement inputPeso = driver.findElement(By.id("peso"));
    WebElement inputEnfermedad = driver.findElement(By.id("enfermedad"));
    WebElement inputEstado = driver.findElement(By.id("estado"));
    WebElement inputFoto = driver.findElement(By.id("foto"));
    WebElement selectCliente = driver.findElement(By.id("clientes"));
    inputNombreMascota.sendKeys("Mascota Prueba");
    inputRaza.sendKeys("Raza Prueba");
    inputEdad.sendKeys("5");
    inputPeso.sendKeys("10");
    inputEnfermedad.sendKeys("Enfermedad Prueba");
    inputEstado.sendKeys("");
    inputFoto.sendKeys("");
    selectCliente.sendKeys("Cliente prueba");
    selectCliente.sendKeys(Keys.ENTER);

    // Guarda la mascota.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSaveMascota")));
    WebElement btnSaveMascota = driver.findElement(By.id("btnSaveMascota"));
    btnSaveMascota.click();

    // Navega al inicio y abre la vista de mascotas para verificar.
    driver.navigate().to(BASE_URL + "/");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnVerMisMascotas")));
    WebElement btnVerMisMascotas = driver.findElement(By.id("btnVerMisMascotas"));
    Actions actions = new Actions(driver);
    actions.moveToElement(btnVerMisMascotas).click().perform();

    // Busca la mascota ingresando la cédula del cliente.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
    WebElement inputCedulaClienteMascotas = driver.findElement(By.id("cedula"));
    inputCedulaClienteMascotas.sendKeys("456123");

    // Realiza la búsqueda de la mascota.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnBuscarMascotas")));
    WebElement btnBuscarMascotas = driver.findElement(By.id("btnBuscarMascotas"));
    btnBuscarMascotas.click();

    // Verifica que la mascota aparezca en los resultados.
    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("p-card-title")));
    WebElement nombreMascota = driver.findElement(By.className("p-card-title"));
    Assertions.assertThat(nombreMascota.getText()).isEqualTo("Mascota Prueba");
  }

  @AfterEach
  void tearDown() {
    // driver.quit();
  }
}
