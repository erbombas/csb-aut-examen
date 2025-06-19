package com.demoblaze.task;

import com.github.javafaker.Faker;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.commons.lang3.StringUtils;

import static com.demoblaze.uis.DemoBlazeUserInterface.*;

public class Registro implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_SIGN_UP),
                Enter.theValue(
                        String.format("%s%s%d",
                                StringUtils.capitalize(Faker.instance().name().firstName()),
                                StringUtils.capitalize(Faker.instance().name().lastName()),
                                Faker.instance().number().numberBetween(100, 999)
                        )).into(TXT_USERNAME),
                Enter.theValue(
                        String.format("%s%s%d",
                                StringUtils.capitalize(Faker.instance().name().firstName()),
                                StringUtils.capitalize(Faker.instance().name().lastName()),
                                Faker.instance().number().numberBetween(100, 999)
                        )
                ).into(TXT_PASSWORD),
                Click.on(BTN_REGISTRO)
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Registro enLaPlataforma() {
        return Instrumented.instanceOf(Registro.class).withProperties();
    }
}
