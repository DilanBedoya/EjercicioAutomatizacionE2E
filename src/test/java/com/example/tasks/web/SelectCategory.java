package com.example.tasks.web;

import com.example.userinterfaces.pages.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.Tasks.instrumented;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectCategory implements Task {

    private final String categoria;

    public SelectCategory(String categoria) {
        this.categoria = categoria;
    }


    public static SelectCategory obtenerCategoria(String categoria) {
        return instrumented(SelectCategory.class, categoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch (categoria) {
            case "Phones":
                actor.attemptsTo(
                        WaitUntil.the(DashboardPage.PHONES_CATEGORY, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(DashboardPage.PHONES_CATEGORY));
                break;
            case "Laptops":
                actor.attemptsTo(
                        WaitUntil.the(DashboardPage.LAPTOPS_CATEGORY, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(DashboardPage.LAPTOPS_CATEGORY));
                break;
            case "Monitors":
                actor.attemptsTo(
                        WaitUntil.the(DashboardPage.MONITORS_CATEGORY, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(DashboardPage.MONITORS_CATEGORY));
                break;
            default:
                throw new IllegalArgumentException("Categoría no encontrada: " + categoria);
        }

    }
}
