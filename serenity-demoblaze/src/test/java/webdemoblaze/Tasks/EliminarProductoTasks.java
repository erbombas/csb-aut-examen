package webdemoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import webdemoblaze.ui.CartElements;

public class EliminarProductoTasks implements Task {

    public static EliminarProductoTasks fromCart() {
        return Tasks.instrumented(EliminarProductoTasks.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CartElements.ELIMINAR));
    }
} 