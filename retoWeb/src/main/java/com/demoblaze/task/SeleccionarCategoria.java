package com.demoblaze.task;

import com.demoblaze.interactions.DetenerTiempo;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.uis.DemoBlazeUserInterface.*;

public class SeleccionarCategoria implements Task {

    private String categoria;

    public SeleccionarCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CATEGORY.of(categoria)),
                DetenerTiempo.porSegundos(2)
        );
    }

    public static SeleccionarCategoria enPantalla(String categoria) {
        return Instrumented.instanceOf(SeleccionarCategoria.class).withProperties(categoria);
    }
}
