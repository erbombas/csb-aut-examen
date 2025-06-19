package com.demoblaze.task;

import com.demoblaze.interactions.DetenerTiempo;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.uis.DemoBlazeUserInterface.*;


public class IngresarAlCarritoDeCompras implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CART),
                DetenerTiempo.porSegundos(6)
        );
    }

    public static IngresarAlCarritoDeCompras enLaPlataforma() {
        return Instrumented.instanceOf(IngresarAlCarritoDeCompras.class).withProperties();
    }
}
