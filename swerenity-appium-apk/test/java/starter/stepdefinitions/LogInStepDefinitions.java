package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.tasks.*;
import starter.ui.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class LogInStepDefinitions {

    @Managed(driver = "Appium")
    public WebDriver hisMobileDevice;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    // CA01
    @Given("abrimos la APK en el emulador")
    public void abrimosLaAPKEnElEmulador() {
        theActorCalled("Mobile User");
    }

    @When("se muestra la pantalla inicial")
    public void seMuestraLaPantallaInicial() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LoginView.TITLE).isDisplayed()
        );
    }

    @Then("debe verse el título 'Swag Labs' y el botón 'LOGIN'")
    public void debeVerseElTituloYBotonLOGIN() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LoginView.TITLE).isDisplayed(),
                Ensure.that(LoginView.BUTTON).text().isEqualTo("LOGIN")
        );
    }

    // CA02
    @Given("estamos en la pantalla inicial")
    public void estamosEnLaPantallaInicial() {
        this.seMuestraLaPantallaInicial();
    }

    @When("ingresamos usuario {string} y contraseña {string}")
    public void ingresamosUsuarioYContrasena(String usuario, String contrasena) {
        theActorInTheSpotlight().attemptsTo(
                EnterCredentials.with(usuario, contrasena)
        );
    }

    @And("pulsamos LOGIN")
    public void pulsamosLOGIN() {
        theActorInTheSpotlight().attemptsTo(
                ClickLoginButton.now()
        );
    }

    @Then("debe mostrarse la lista de productos")
    public void debeMostrarseLaListaDeProductos() {
        theActorInTheSpotlight().should(
                seeThat(WebElementQuestion.the(ProductsView.PRODUCT_LIST), isVisible())
        );
    }

    // CA03
    @Given("vemos la lista de productos")
    public void vemosLaListaDeProductos() {
        this.debeMostrarseLaListaDeProductos();
    }

    @When("seleccionamos el producto {string}")
    public void seleccionamosElProducto(String productName) {
        theActorInTheSpotlight().attemptsTo(
                ClickProduct.named(productName)
        );
    }

    @And("pulsamos ADD TO CART")
    public void pulsamosADDTOCAR() {
        theActorInTheSpotlight().attemptsTo(
                ClickAddToCart.now()
        );
    }

    @Then("el carrito debe contener {string}")
    public void elCarritoDebeContenerProducto(String productName) {
        theActorInTheSpotlight().should(
                seeThat(WebElementQuestion.the(CartView.PRODUCT_CAR(productName)), isVisible())
        );
    }

    // CA04
    @Given("{string} está en el carrito")
    public void productoEstaEnElCarrito(String productName) {
        this.elCarritoDebeContenerProducto(productName);
    }

    @When("abrimos el carrito")
    public void abrimosElCarrito() {
        theActorInTheSpotlight().attemptsTo(
                OpenCart.now()
        );
    }

    @Then("debe listarse {string} junto a su precio")
    public void debeListarseProductoConPrecio(String productName) {
        theActorInTheSpotlight().should(
                seeThat(WebElementQuestion.the(CartView.PRODUCT_CAR(productName)), isVisible()),
                seeThat(WebElementQuestion.the(CartView.PRODUCT_PRICE(productName)), isVisible())
        );
    }

    // CA05
    @When("pulsamos REMOVE junto al {string}")
    public void pulsamosREMOVEJuntoAlProducto(String productName) {
        theActorInTheSpotlight().attemptsTo(
                RemoveProduct.named(productName)
        );
    }

    @Then("el carrito debe quedar vacío")
    public void elCarritoDebeQuedarVacio() {
        theActorInTheSpotlight().should(
                seeThat(WebElementQuestion.the(CartView.EMPTY_CART), isVisible())
        );
    }

    // CA06
    @Given("estamos en cualquier pantalla de la app")
    public void estamosEnCualquierPantallaDeLaApp() {
        theActorInTheSpotlight().should(
                seeThat(WebElementQuestion.the(MainView.MENU_BUTTON), isVisible())
        );
    }

    @When("abrimos el menú lateral y pulsamos “About”")
    public void abrimosElMenuYLuegoPulsamosAbout() {
        theActorInTheSpotlight().attemptsTo(
                OpenAboutSection.now()
        );
    }

    @Then("debe mostrarse la sección con texto “Swag Labs”")
    public void debeMostrarseSeccionSwagLabs() {
        theActorInTheSpotlight().should(
                seeThat(WebElementQuestion.the(MenuView.SWAG_LABS_SECTION), isVisible())
        );
    }

    // CA07
    @Given("estamos logueados")
    public void estamosLogueados() {
        this.ingresamosUsuarioYContrasena("standard_user", "secret_sauce");
        this.pulsamosLOGIN();
    }

    @When("pulsamos el botón “LOGOUT”")
    public void pulsamosElBotonLogout() {
        theActorInTheSpotlight().attemptsTo(
                Logout.now()
        );
    }

    @Then("regresa a la pantalla de login")
    public void regresaALaPantallaDeLogin() {
        theActorInTheSpotlight().should(
                seeThat(WebElementQuestion.the(LoginView.BUTTON), isVisible())
        );
    }
}
