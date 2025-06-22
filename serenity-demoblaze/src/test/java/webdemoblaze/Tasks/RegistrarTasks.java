package webdemoblaze.tasks;

import java.time.Duration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import webdemoblaze.ui.SignUpElements;

public class RegistrarTasks implements Task {
    private String username;
    private String password;

    public RegistrarTasks(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static RegistrarTasks with(String username, String password) {
        return Tasks.instrumented(RegistrarTasks.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(SignUpElements.USUARIO_REGISTRO, WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
            Enter.theValue(username).into(SignUpElements.USUARIO_REGISTRO),
            WaitUntil.the(SignUpElements.CLAVE_REGISTRO, WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
            Enter.theValue(password).into(SignUpElements.CLAVE_REGISTRO)
        );
    }
}