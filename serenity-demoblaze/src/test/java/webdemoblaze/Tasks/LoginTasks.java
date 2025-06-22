package webdemoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import webdemoblaze.ui.LoginElements;

public class LoginTasks implements Task {
    private String username;
    private String password;

    public LoginTasks(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginTasks with(String username, String password) {
        return Tasks.instrumented(LoginTasks.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(LoginElements.USUARIO_INGRESO, WebElementStateMatchers.isVisible()),
            Enter.theValue(username).into(LoginElements.USUARIO_INGRESO),

            WaitUntil.the(LoginElements.CLAVE_INGRESO, WebElementStateMatchers.isVisible()),
            Enter.theValue(password).into(LoginElements.CLAVE_INGRESO)
        );
    }
}

