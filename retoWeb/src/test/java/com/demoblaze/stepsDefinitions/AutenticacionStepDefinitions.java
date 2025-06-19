package com.demoblaze.stepsDefinitions;

import com.demoblaze.driver.NavegadorWedDriver;

import com.demoblaze.questions.ValidarNombre;
import com.demoblaze.questions.ValidarTextoAlerta;
import com.demoblaze.task.Login;
import com.demoblaze.task.Registro;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Transpose;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.demoblaze.uis.DemoBlazeUserInterface.*;

public class AutenticacionStepDefinitions {
    static Map<String, String> values;

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que me encuentro en la pantalla inicial de Demoblaze")
    public void queMeEncuentroEnLaPantallaInicialDeDemoblaze() {
        OnStage.theActorCalled("Yilmar").can(BrowseTheWeb.with(NavegadorWedDriver.chromeHisBrowserWeb().on("https://www.demoblaze.com/index.html")));

    }
    @Cuando("realizo el registro de un nuevo usuario")
    public void realizoElRegistroDeUnNuevoUsuario() {
        OnStage.theActorInTheSpotlight().attemptsTo(Registro.enLaPlataforma());

    }
    @Entonces("podre ver el siguiente mensaje de la alerta {string}")
    public void podreVerElSiguienteMensajeDeLaAlerta(String texto) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarTextoAlerta.enPantalla(texto)));

    }





    @Cuando("ingreso mis credenciales e ingreso a la plataforma")
    public void ingresoMisCredencialesEIngresoALaPlataforma(@Transpose DataTable dataTable) {

        values = new HashMap<>(dataTable.asMap(String.class, String.class));
        OnStage.theActorInTheSpotlight().attemptsTo(Login.enLaPlataforma(values));

    }
    @Entonces("podre ver mi  usuario {string} en la esquina superior derecha")
    public void podreVerMiUsuarioEnLaEsquinaSuperiorDerecha(String texto) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarNombre.enPantalla(TXT_NAME_USERNAME, texto)));

    }




}
