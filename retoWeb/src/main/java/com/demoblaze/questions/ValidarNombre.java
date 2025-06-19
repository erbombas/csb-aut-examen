package com.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidarNombre implements Question<Boolean> {
    private String texto;
    private Target target;

    public ValidarNombre(Target target, String texto) {
        this.texto = texto;
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).getText().contains(texto);
    }

    public static Question<Boolean> enPantalla(Target target, String texto) {
        return new ValidarNombre(target, texto);
    }
}
