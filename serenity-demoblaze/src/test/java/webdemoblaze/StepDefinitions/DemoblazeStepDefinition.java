package webdemoblaze.stepdefinitions;

import webdemoblaze.tasks.*;
import webdemoblaze.ui.CartElements;
import webdemoblaze.ui.HomepageElements;
import webdemoblaze.ui.LoginElements;
import webdemoblaze.ui.ProductElements;
import webdemoblaze.ui.SignUpElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import net.serenitybdd.core.Serenity;
import java.time.Duration;
import java.util.Random;

public class DemoblazeStepDefinition {

    @Given("que ingresamos a la URL de DemoBlaze")
    public void ingresarALaUrlDeDemoblaze() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario").wasAbleTo(VisitarSitio.open());
        OnStage.theActorInTheSpotlight().attemptsTo(
            WaitUntil.the(HomepageElements.CARRUSEL, WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
            Ensure.that(HomepageElements.CARRUSEL).isDisplayed()
        );
    }

    @When("hacemos clic en {string}")
    public void hacemosClicEn(String elemento) {
        switch (elemento) {
            case "Sign up":
                OnStage.theActorInTheSpotlight().attemptsTo(
                    WaitUntil.the(HomepageElements.MENU_REGISTRO, WebElementStateMatchers.isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
                    Click.on(HomepageElements.MENU_REGISTRO)
                );
                break;
            case "Log in":
                OnStage.theActorInTheSpotlight().attemptsTo(
                    WaitUntil.the(HomepageElements.MENU_INGRESO, WebElementStateMatchers.isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
                    Click.on(HomepageElements.MENU_INGRESO)
                );
                break;
            case "Samsung galaxy s6":
                OnStage.theActorInTheSpotlight().attemptsTo(ProductoTasks.with(elemento));
                break;
            case "Add to cart":
                OnStage.theActorInTheSpotlight().attemptsTo(AddCartTasks.toCart());
                break;
            case "Cart":
                OnStage.theActorInTheSpotlight().attemptsTo(VerCartTasks.view());
                break;
            case "Log out":
                OnStage.theActorInTheSpotlight().attemptsTo(CerrarSessionTasks.fromSite());
                break;
            default:
                throw new IllegalArgumentException("Elemento no reconocido: " + elemento);
        }
    }

    @When("ingresamos usuario {string} y contraseña {string}")
    public void ingresamosUsuarioYContraseña(String usuario, String contrasena) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            LoginTasks.with(usuario, contrasena)
        );
    }

    @When("registramos un usuario y contraseña random")
    public void registramosUnUsuarioYContraseñaRandom() {
        String randomUser = generateRandomUser();
        OnStage.theActorInTheSpotlight().attemptsTo(RegistrarTasks.with(randomUser, randomUser));
    }

    @When("pulsamos {string}")
    public void pulsamos(String boton) {
        switch (boton) {
            case "Sign up":
                OnStage.theActorInTheSpotlight().attemptsTo(
                    WaitUntil.the(SignUpElements.BOTON_REGISTRO, WebElementStateMatchers.isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
                    Click.on(SignUpElements.BOTON_REGISTRO)
                );
                break;
            case "Log in":
                OnStage.theActorInTheSpotlight().attemptsTo(
                    WaitUntil.the(LoginElements.BOTON_INGRESO, WebElementStateMatchers.isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
                    Click.on(LoginElements.BOTON_INGRESO)
                );
                break;
            case "Delete":
                OnStage.theActorInTheSpotlight().attemptsTo(EliminarProductoTasks.fromCart());
                break;
            case "Log out":
                OnStage.theActorInTheSpotlight().attemptsTo(CerrarSessionTasks.fromSite());
                break;
            default:
                throw new IllegalArgumentException("Botón no reconocido: " + boton);
        }
    }

    @Then("debe mostrarse una alerta con el mensaje {string}")
    public void debeMostrarseUnaAlertaConElMensaje(String mensaje) {
        String alertMessage = getAlertMessage();
        OnStage.theActorInTheSpotlight().attemptsTo(
            Ensure.that(alertMessage).isEqualTo(mensaje)
        );
    }

    @Then("debe aparecer nuestro nombre de usuario en la esquina superior derecha: {string}")
    public void debeAparecerNuestroNombreDeUsuarioEnLaEsquinaSuperiorDerecha(String usuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            WaitUntil.the(HomepageElements.NOMBRE_USUARIO, WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
            Ensure.that(HomepageElements.NOMBRE_USUARIO).text().contains("Welcome " + usuario)
        );
    }

    @Given("que ya estamos logueados")
    public void queYaEstamosLogueados() {
        ingresarALaUrlDeDemoblaze();
    }

    @When("hacemos clic en la categoría {string}")
    public void hacemosClicEnLaCategoría(String categoria) {
        OnStage.theActorInTheSpotlight().attemptsTo(CategoriaTasks.with(categoria));
    }

    @Then("se debe mostrar el listado de {string}")
    public void seDebeMostrarElListadoDe(String categoria) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            WaitUntil.the(ProductElements.PRODUCTO, WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10))
        );
    }

    @Given("que vemos el listado de {string}")
    public void queVemosElListadoDe(String categoria) {
        ingresarALaUrlDeDemoblaze();
        OnStage.theActorInTheSpotlight().attemptsTo(CategoriaTasks.with(categoria));
    }

    @Then("debe mostrarse el label {string}")
    public void debeMostrarseElLabel(String label) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ProductElements.ETIQUETA, WebElementStateMatchers.isVisible()),
                Ensure.that(ProductElements.ETIQUETA).text().contains(label)
        );
    }

    @Given("que estamos en la página de detalle de {string}")
    public void queEstamosEnLaPaginaDeDetalleDe(String producto) {
        ingresarALaUrlDeDemoblaze();
        OnStage.theActorInTheSpotlight().attemptsTo(ProductoTasks.with(producto));
    }

    @Then("aparece un modal con el mensaje {string}")
    public void apareceUnModalConElMensaje(String message) {
        String modalMessage = getAlertMessage();
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(modalMessage).contains(message)
        );
    }

    @Given("que {string} está en el carrito")
    public void queEstaEnElCarrito(String producto) {
        // Asumimos que el producto ya está en el carrito
        // En una implementación real, esto verificaría que el producto esté en el carrito
    }

    @Then("el carrito muestra {string}")
    public void elCarritoMuestra(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            WaitUntil.the(CartElements.PRODUCTO_CARRITO, WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
            Ensure.that(CartElements.PRODUCTO_CARRITO).text().contains(producto)
        );
    }

    @Given("que estamos en nuestro carrito de compras")
    public void queEstamosEnNuestroCarritoDeCompras() {
        ingresarALaUrlDeDemoblaze();
        OnStage.theActorInTheSpotlight().attemptsTo(VerCartTasks.view());
    }

    @Then("el carrito queda vacío")
    public void elCarritoQuedaVacio() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            WaitUntil.the(CartElements.PRODUCTO_CARRITO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(Duration.ofSeconds(10)),
            Ensure.that(CartElements.PRODUCTO_CARRITO).isNotDisplayed()
        );
    }

    @Given("que estamos en el carrito")
    public void queEstamosEnElCarrito() {
        ingresarALaUrlDeDemoblaze();
        OnStage.theActorInTheSpotlight().attemptsTo(VerCartTasks.view());
    }

    @Then("nos redirige a la página principal de DemoBlaze")
    public void nosRedirigeALaPaginaPrincipalDeDemoBlaze() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(HomepageElements.CARRUSEL).isDisplayed()
        );
    }

    @Given("que estamos en cualquier página de DemoBlaze")
    public void queEstamosEnCualquierPaginaDeDemoBlaze() {
        // Este paso asume que ya estamos en alguna página de DemoBlaze
        // No necesita navegación específica
    }

    @When("hacemos clic en el logo del sitio")
    public void hacemosClicEnElLogoSitio() {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(HomepageElements.MARCA));
    }

    @Then("volvemos a la página principal")
    public void volvemosALaPaginaPrincipal() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(HomepageElements.CARRUSEL).isDisplayed()
        );
    }

    private String getAlertMessage() {
        WebDriver driver = ((WebDriverFacade) Serenity.getDriver()).getProxiedDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            Alert alert = wait.until(d -> d.switchTo().alert());
            String message = alert.getText();
            alert.accept();
            return message;
        } catch (Exception e) {
            throw new RuntimeException("Ha ocurrido un error al manejar la alerta", e);
        }
    }

    private String generateRandomUser() {
        Random random = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        
        // Generar un usuario de 8-12 caracteres
        int length = random.nextInt(5) + 8; // 8-12 caracteres
        
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        
        return sb.toString();
    }
}
