package starter.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Actor;

import starter.ui.CartView;

public class RemoveProduct implements Task {

    private final String productName;

    public RemoveProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartView.REMOVE_BUTTON(productName))
        );
    }

    public static RemoveProduct named(String productName) {
        return new RemoveProduct(productName);
    }
}
