package starter.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import starter.ui.ProductDetailsView;

import net.serenitybdd.screenplay.Actor;

public class ClickAddToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductDetailsView.ADD_TO_CART)
        );
    }

    public static ClickAddToCart now() {
        return new ClickAddToCart();
    }
}