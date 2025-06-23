package starter.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import starter.ui.LoginView;

import net.serenitybdd.screenplay.Actor;

public class ClickLoginButton implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginView.BUTTON)
        );
    }

    public static ClickLoginButton now() {
        return new ClickLoginButton();
    }
}
