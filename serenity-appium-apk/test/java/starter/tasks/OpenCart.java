package starter.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Actor;

import starter.ui.ProductsView;

public class OpenCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsView.CART)
        );
    }

    public static OpenCart now() {
        return new OpenCart();
    }
}