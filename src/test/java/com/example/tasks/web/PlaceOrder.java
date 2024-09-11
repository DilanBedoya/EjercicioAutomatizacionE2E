package com.example.tasks.web;

import com.example.userinterfaces.pages.CarPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PlaceOrder implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CarPage.BTN_PLACE_ORDER)
        );

        try {
            // Pausar la ejecución durante 3 segundos
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
            throw new RuntimeException(e);
        }
    }

    public static PlaceOrder lookForm() {
        return instrumented(PlaceOrder.class);
    }
}
