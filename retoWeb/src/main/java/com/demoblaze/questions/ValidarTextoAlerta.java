package com.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidarTextoAlerta implements Question<Boolean> {
    private String texto;

    public ValidarTextoAlerta(String texto) {
        this.texto = texto;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String textoAlerta = BrowseTheWeb.as(actor).getDriver().switchTo().alert().getText();
        if(textoAlerta.equals(this.texto)){
            BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
            return true;
        }else{
            return false;
        }
    }

    public static Question<Boolean> enPantalla(String texto) {
        return new ValidarTextoAlerta(texto);
    }
}
