package webdemoblaze.tasks;

import java.time.Duration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import webdemoblaze.ui.CartElements;

public class VerCartTasks implements Task {

    public static VerCartTasks view() {
        return Tasks.instrumented(VerCartTasks.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(CartElements.CARRITO, WebElementStateMatchers.isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
            Click.on(CartElements.CARRITO)
        );
    }
} 