package com.petStore.interactions;

import com.petStore.Utils.Utilidades;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostRest implements Interaction{
	
	private String requestConsume = "{}";
	private String endPointOrWSDL = "";

	@Override
	public <T extends Actor> void performAs(T actor) {
		

		actor.attemptsTo(Post.to(endPointOrWSDL)
				.with(request -> request
						.log().all()
						.header("Content-Type", "application/json")
						.header("Accept","*/*")
				.body(requestConsume)));
		System.out.println(SerenityRest.lastResponse().asString());
		Utilidades.setProperty("ID_PET", String.valueOf(Utilidades.getIdFromJson(SerenityRest.lastResponse().asString())));
	}
	
	public static PostRest on() {
		return Instrumented.instanceOf(PostRest.class).withProperties();
	}

	public PostRest withBodyRequest(String requestConsume)
    {
        this.requestConsume = requestConsume;
        return this;
    }
	
	public PostRest withEndPoint(String endPoint)
    {
        this.endPointOrWSDL = endPoint;
        return this;
    }
}
