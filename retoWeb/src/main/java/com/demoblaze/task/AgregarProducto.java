package com.demoblaze.task;

import com.demoblaze.interactions.DetenerTiempo;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.uis.DemoBlazeUserInterface.*;


public class AgregarProducto implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ADD_CART),
                DetenerTiempo.porSegundos(3)
        );
    }

    public static AgregarProducto alCarrito() {
        return Instrumented.instanceOf(AgregarProducto.class).withProperties();
    }
}
