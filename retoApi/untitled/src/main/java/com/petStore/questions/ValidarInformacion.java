package com.petStore.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarInformacion implements Question<Boolean> {

    private String informacion;

    public ValidarInformacion(String informacion) {
        this.informacion = informacion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (SerenityRest.lastResponse().asString().contains(informacion));
    }

    public static Question<Boolean> enResponse(String informacion) {
        return new ValidarInformacion(informacion);
    }
}
