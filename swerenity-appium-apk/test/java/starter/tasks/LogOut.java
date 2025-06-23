package starter.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Actor;

import starter.ui.HomeView;

public class Logout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeView.LOGOUT_BUTTON)
        );
    }

    public static Logout now() {
        return new Logout();
    }
}
