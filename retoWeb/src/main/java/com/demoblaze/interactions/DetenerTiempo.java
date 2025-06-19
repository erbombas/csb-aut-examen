package com.demoblaze.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import net.serenitybdd.screenplay.Tasks;

import java.time.Duration;

public class DetenerTiempo implements Interaction {

    private final Duration duracion;

    public DetenerTiempo(int segundos) {
        this.duracion = Duration.ofSeconds(segundos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(duracion.toMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static DetenerTiempo porSegundos(int segundos) {
        return Tasks.instrumented(DetenerTiempo.class, segundos);
    }
}
