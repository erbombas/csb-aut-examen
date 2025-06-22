package webdemoblaze.tasks;

import java.time.Duration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import webdemoblaze.ui.HomepageElements;

public class CerrarSessionTasks implements Task {

    public static CerrarSessionTasks fromSite() {
        return Tasks.instrumented(CerrarSessionTasks.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(HomepageElements.MENU_SALIR, WebElementStateMatchers.isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
            Click.on(HomepageElements.MENU_SALIR)
        );
    }
} 