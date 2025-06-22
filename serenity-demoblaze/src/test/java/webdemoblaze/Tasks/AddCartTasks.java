package webdemoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import webdemoblaze.ui.CartElements;

public class AddCartTasks implements Task {

    public static AddCartTasks toCart() {
        return Tasks.instrumented(AddCartTasks.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CartElements.AGREGAR_CARRITO));
    }
} 