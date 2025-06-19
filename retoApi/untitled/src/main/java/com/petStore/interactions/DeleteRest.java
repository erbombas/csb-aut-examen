package com.petStore.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Delete;


public class DeleteRest implements Interaction{

	private String endPointOrWSDL;

	public DeleteRest(String path) {
		this.endPointOrWSDL = path;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Delete.from(endPointOrWSDL)
				.with(request -> request.header("Content-Type", "application/json")
				.header("Accept","*/*")));
		System.out.println(SerenityRest.lastResponse().asString());
	}
	
	public static Performable on(String endPointOrWSDL) {
		return Instrumented.instanceOf(DeleteRest.class).withProperties(endPointOrWSDL);
	}
}
