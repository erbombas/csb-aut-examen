package com.demoblaze.stepsDefinitions;

import com.demoblaze.driver.NavegadorWedDriver;
import com.demoblaze.questions.ValidarTextoAlerta;
import com.demoblaze.task.*;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;


import java.io.IOException;

import static com.demoblaze.uis.DemoBlazeUserInterface.*;

public class GestionProductosStepDefinitions {
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que me encuentro en la pantalla inicial de Store")
    public void queMeEncuentroEnLaPantallaInicialDeStore() {
        OnStage.theActorCalled("Yilmar").can(BrowseTheWeb.with(NavegadorWedDriver.chromeHisBrowserWeb().on("https://www.demoblaze.com/index.html")));

    }

   @Cuando("selecciono la categoría {string}")
    public void seleccionoLaCategoría(String categoria) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarCategoria.enPantalla(categoria));


    }
    @Cuando("selecciono el producto {string}")
    public void seleccionoElProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarProducto.enPantalla(producto));

    }
    @Entonces("podre ver el detalle del producto con la etiqueta {string}")
    public void podreVerElDetalleDelProductoConLaEtiqueta(String descripcion) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(TXT_TITLE_DESCRIPCION), WebElementStateMatchers.containsText(descripcion)));

    }
    @Cuando("agrego el producto al carrito")
    public void agregoElProductoAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarProducto.alCarrito());

    }
     @Entonces("podre ver el mensaje de la alerta {string}")
    public void podreVerElMensajeDeLaAlerta(String textoAlerta) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarTextoAlerta.enPantalla(textoAlerta)));
    }
    @Cuando("accedo a la seccion Cart desde el menu")
    public void accedoALaSeccionCartDesdeElMenu() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlCarritoDeCompras.enLaPlataforma());

    }
    @Entonces("podre ver el producto {string} agregado en mi carrito de compras")
    public void podreVerElProductoAgregadoEnMiCarritoDeCompras(String producto) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(TXT_PRODUCT_CART.of(producto)), WebElementStateMatchers.containsText(producto)));

    }

    @Cuando("elimino el producto {string} del carrito")
    public void eliminoElProductoDelCarrito(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(EliminarProducto.enPantalla(producto));

    }
    @Entonces("el producto {string} desaparecerá del listado")
    public void elProductoDesapareceráDelListado(String producto) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(TXT_PRODUCT_CART.of(producto)), WebElementStateMatchers.isNotVisible()));
    }
}
