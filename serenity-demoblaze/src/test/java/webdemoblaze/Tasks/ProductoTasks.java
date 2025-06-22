package webdemoblaze.tasks;

import java.time.Duration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import webdemoblaze.ui.ProductElements;

public class ProductoTasks implements Task {
    
    public static ProductoTasks with(String producto) {
        return Tasks.instrumented(ProductoTasks.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(ProductElements.PRODUCTO, WebElementStateMatchers.isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
            Click.on(ProductElements.PRODUCTO)
        );
    }
} 