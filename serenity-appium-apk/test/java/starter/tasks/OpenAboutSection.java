package starter.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Actor;

import starter.ui.MenuView;

public class OpenAboutSection implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MenuView.MENU_BUTTON),
                Click.on(MenuView.ABOUT)
        );
    }

    public static OpenAboutSection now() {
        return new OpenAboutSection();
    }
}
