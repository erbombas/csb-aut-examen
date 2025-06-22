package webdemoblaze.tasks;

import java.time.Duration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import webdemoblaze.ui.CategoryElements;

public class CategoriaTasks implements Task {
   
    public static CategoriaTasks with(String categoria) {
        return Tasks.instrumented(CategoriaTasks.class, categoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(CategoryElements.CATEGORIA, WebElementStateMatchers.isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
            Click.on(CategoryElements.CATEGORIA)
        );
    }
} 