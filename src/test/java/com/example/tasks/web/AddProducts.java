package com.example.tasks.web;

import com.example.userinterfaces.pages.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProducts implements Task {


    public static AddProducts AddProduct() {
        return instrumented(AddProducts.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ProductPage.BTN_ADD_CAR, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ProductPage.BTN_ADD_CAR)
        );
        try {
            // Pausar la ejecución durante 3 segundos
            Thread.sleep(3000);
            // Cambiar el foco a la alerta

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
            throw new RuntimeException(e);
        }
    }

}
