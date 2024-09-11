package com.example.tasks.web;

import com.example.userinterfaces.pages.CarPage;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateTo implements Task {
    EnvironmentVariables environmentVariables;

    private final String url;

    public NavigateTo(String url) {
        this.url = url;
    }


    @Override
    @Step("{0} Inicia la página #url")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.url(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(url))

        );
        try {
            // Pausar la ejecución durante 3 segundos
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
            throw new RuntimeException(e);
        }
    }


    public static Task DemoBlazePage() {
        String url = "webdriver.base.dashboard";
        return instrumented(NavigateTo.class, url);
    }

    public static Task CartPage() {
        String url = "webdriver.base.cart";
        return instrumented(NavigateTo.class, url);

    }


}
