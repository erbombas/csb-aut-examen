package com.petStore.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutRest implements Interaction{
	private String requestConsume = "{}";
	private String endPointOrWSDL = "";

	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Put.to(endPointOrWSDL)
				.with(request -> request
						.header("Content-Type", "application/json")
						.header("Accept","*/*")
				.body(requestConsume)));
		System.out.println(SerenityRest.lastResponse().asString());
	}
	
	public static PutRest on() {
		return Instrumented.instanceOf(PutRest.class).withProperties();
	}
	
	public PutRest withBodyRequest(String requestConsume)
    {
        this.requestConsume = requestConsume;
        return this;
    }
	
	public PutRest withEndPoint(String endPoint)
    {
        this.endPointOrWSDL = endPoint;
        return this;
    }
}
