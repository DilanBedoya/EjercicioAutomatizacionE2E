package com.example.stepdefinitions.web;

import com.example.questions.web.ProductsQuestion;
import com.example.tasks.web.*;
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

import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.equalTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class BuyStepsDefs {

    private Scenario scenario;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("El {string} está en la página principal de DemoBlaze")
    public void elEstáEnLaPáginaPrincipalDeDemoBlaze(String actor) {
        theActorCalled(actor).attemptsTo(
                NavigateTo.DemoBlazePage()
        );
        screenShot();
    }


    @When("selecciona la categoría {string} para el primer producto")
    public void seleccionaLaCategoríaParaElPrimerProducto(String categoria) {
        theActorInTheSpotlight().attemptsTo(
                SelectCategory.obtenerCategoria(categoria)
        );
        screenShot();

    }

    @And("selecciona el primer producto {string}")
    public void seleccionaElPrimerProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(
                SelectProducts.obtenerProducto(producto)
        );
        screenShot();

    }


    @And("agrega al carrito el primero producto")
    public void agregaAlCarritoElPrimeroProducto() {
        theActorInTheSpotlight().attemptsTo(
                AddProducts.AddProduct(),
                NavigateTo.DemoBlazePage()

        );
        screenShot();

    }

    @When("selecciona la categoría {string} para el segundo producto")
    public void seleccionaLaCategoríaParaElSegundoProducto(String categoria) {
        theActorInTheSpotlight().attemptsTo(
                SelectCategory.obtenerCategoria(categoria)
        );
        screenShot();

    }

    @And("selecciona el segundo producto {string}")
    public void seleccionaElSegundoProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(
                SelectProducts.obtenerProducto(producto)
        );
        screenShot();

    }

    @And("agrega al carrito el segundo producto")
    public void agregaAlCarritoElSegundoProducto() {
        theActorInTheSpotlight().attemptsTo(
                AddProducts.AddProduct(),
                NavigateTo.DemoBlazePage(),
                NavigateTo.CartPage()
        );
        screenShot();

    }

    @Then("se muestran los productos {string} y {string} en el carrito")
    public void seMuestranLosProductosYEnElCarrito(String producto1, String producto2) {
        System.out.println(producto1);
        System.out.println(producto2);

        theActorInTheSpotlight().should(
                seeThat("El título del primer producto es visible",
                        ProductsQuestion.titleProducts1(),
                        either(equalTo(producto1)).or(equalTo(producto2)) // El primer producto puede ser igual a producto1 o producto2 ya que la página cambia el orden con cada actualización
                ));

        theActorInTheSpotlight().should(
                seeThat("El título del segundo producto es visible",
                        ProductsQuestion.titleProducts2(),
                        either(equalTo(producto1)).or(equalTo(producto2)) // El segundo producto puede ser igual a producto1 o producto2 ya que la página cambia el orden con cada actualización
                ));
        screenShot();

    }

    public void screenShot() {
        byte[] evidencia = ((TakesScreenshot) BrowseTheWeb.as(theActorInTheSpotlight()).getDriver()).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
}
