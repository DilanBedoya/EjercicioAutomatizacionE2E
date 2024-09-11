package com.example.stepdefinitions.web;


import com.example.questions.web.PurchaseQuestion;
import com.example.tasks.web.CompleteForm;
import com.example.tasks.web.NavigateTo;
import com.example.tasks.web.PlaceOrder;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class FormStepdefs {

    private Scenario scenario;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("El {string} está en la sección de carrito")
    public void elEstáEnLaSecciónDeCarrito(String actor) {
        theActorCalled(actor).attemptsTo(
                NavigateTo.DemoBlazePage(),
                NavigateTo.CartPage()
        );
        screenShot();
    }

    @When("realiza una orden")
    public void realizaUnaOrden() {
        theActorInTheSpotlight().attemptsTo(
                PlaceOrder.lookForm()
        );
        screenShot();

    }

    @And("llena el formulario con {string},{string},{string},{string},{string} y {string} correctamente")
    public void llenaElFormularioConYCorrectamente(String name, String country, String city, String creditCard, String month, String year) {
        theActorInTheSpotlight().attemptsTo(
                CompleteForm.withData(name, country, city, creditCard, month, year)
        );
        screenShot();

    }

    @Then("visualiza el mensaje {string}")
    public void visualizaElMensaje(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat("El texto de haber realizado la orden fue correcta", PurchaseQuestion.TextPurchase(), equalTo(mensaje)
                ));
        screenShot();

    }

    public void screenShot() {
        byte[] evidencia = ((TakesScreenshot) BrowseTheWeb.as(theActorInTheSpotlight()).getDriver()).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

}
