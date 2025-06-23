package starter.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;

import starter.ui.LoginView;

import net.serenitybdd.screenplay.Actor;

public class EnterCredentials implements Task {

    private final String username;
    private final String password;

    public EnterCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendKeys.of(username).into(LoginView.USERNAME),
                SendKeys.of(password).into(LoginView.PASSWORD)
        );
    }

    public static EnterCredentials with(String username, String password) {
        return new EnterCredentials(username, password);
    }
}
