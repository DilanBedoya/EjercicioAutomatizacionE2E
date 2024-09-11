package com.example.tasks.web;

import com.example.userinterfaces.pages.CarPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteForm implements Task {
    private final String name;
    private final String country;
    private final String city;
    private final String creditCard;
    private final String month;
    private final String year;

    public CompleteForm(String name, String country, String city, String creditCard, String month, String year) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.creditCard = creditCard;
        this.month = month;
        this.year = year;
    }

    public static Performable withData(String name, String country, String city, String creditCard, String month, String year){
        return instrumented(CompleteForm.class, name, country, city, creditCard, month, year);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CarPage.NAME_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(name).into(CarPage.NAME_INPUT),
                Enter.theValue(country).into(CarPage.COUNTRY_INPUT),
                Enter.theValue(city).into(CarPage.CITY_INPUT),
                Enter.theValue(creditCard).into(CarPage.CREDIT_CARD_INPUT),
                Enter.theValue(month).into(CarPage.MONTH_INPUT),
                Enter.theValue(year).into(CarPage.YEAR_INPUT),

                Click.on(CarPage.BTN_PURCHASE)
        );
        try {
            // Pausar la ejecución durante 3 segundos
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
            throw new RuntimeException(e);
        }
    }

}
