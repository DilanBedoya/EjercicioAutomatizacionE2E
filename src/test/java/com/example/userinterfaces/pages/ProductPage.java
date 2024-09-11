package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {

    public static final Target BTN_ADD_CAR = Target.the("Botón de añadir al carrito").located(By.xpath("//a[text()='Add to cart']"));

}
