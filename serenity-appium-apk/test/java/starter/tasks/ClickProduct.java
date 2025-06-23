package starter.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import starter.ui.ProductsView;

import net.serenitybdd.screenplay.Actor;

public class ClickProduct implements Task {
    private final String productName;

    public ClickProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsView.BUTTON)
        );
    }

    public static ClickProduct named(String productName) {
        return new ClickProduct(productName);
    }
}