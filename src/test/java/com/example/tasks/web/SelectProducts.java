package com.example.tasks.web;

import com.example.userinterfaces.pages.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectProducts implements Task {

    private final String producto;

    public SelectProducts(String producto) {
        this.producto = producto;
    }

    public static SelectProducts obtenerProducto(String producto) {
        return instrumented(SelectProducts.class, producto);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        Target productTarget = DashboardPage.getProductButton(producto);
        if (productTarget.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    WaitUntil.the(productTarget, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(productTarget));
            try {
                // Pausar la ejecución durante 3 segundos
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("El producto '" + producto + "' no fue encontrado en la página.");
        }


    }
}
