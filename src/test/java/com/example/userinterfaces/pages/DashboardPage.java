package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {

    //category
    public static final Target PHONES_CATEGORY = Target.the("Categoría Phones").located(By.xpath("//*[@id=\"itemc\" and @onclick=\"byCat('phone')\" and text()=\"Phones\"]"));
    public static final Target LAPTOPS_CATEGORY = Target.the("Categoría Laptops").located(By.xpath("//*[@id=\"itemc\" and @onclick=\"byCat('notebook')\" and text()=\"Laptops\"]"));
    public static final Target MONITORS_CATEGORY = Target.the("Categoría Monitors").located(By.xpath("//*[@id=\"itemc\" and @onclick=\"byCat('monitor')\" and text()=\"Monitors\"]"));


    // Método para obtener el Target de un producto basado en el nombre
    public static Target getProductButton(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío o ser nulo");
        }else {
            return Target.the("Producto " + productName).located(By.xpath("//a[text()='" + productName + "']"));
        }
    }

}
