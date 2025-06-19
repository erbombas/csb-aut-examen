package com.demoblaze.task;

import com.demoblaze.uis.DemoBlazeUserInterface;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class EliminarProducto implements Task {

    private String producto;

    public EliminarProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DemoBlazeUserInterface.BTN_DELETE_PRODUCT.of(producto))
        );
    }

    public static EliminarProducto enPantalla(String producto) {
        return Instrumented.instanceOf(EliminarProducto.class).withProperties(producto);
    }
}
