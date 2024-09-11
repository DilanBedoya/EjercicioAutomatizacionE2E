package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarPage {

    public static final Target BTN_SECTION_CAR = Target.the("Página de Carrito").located(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a"));
    public static final Target PRODUCT_1_TEXT = Target.the("Texto del Primer Producto").located(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[2]"));
    public static final Target PRODUCT_2_TEXT = Target.the("Texto del Segundo Producto").located(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[2]"));
    public static final Target BTN_PLACE_ORDER = Target.the("Botón realizar orden").located(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));

    //Form
    public static final Target NAME_INPUT = Target.the("Campo Name").located(By.id("name"));
    public static final Target COUNTRY_INPUT = Target.the("Campo country").located(By.id("country"));
    public static final Target CITY_INPUT = Target.the("Campo city").located(By.id("city"));
    public static final Target CREDIT_CARD_INPUT = Target.the("Campo credit card").located(By.id("card"));
    public static final Target MONTH_INPUT = Target.the("Campo month").located(By.id("month"));
    public static final Target YEAR_INPUT = Target.the("Campo year").located(By.id("year"));

    public static final Target BTN_PURCHASE = Target.the("Botón Purchase").located(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
    public static final Target PURCHASE_TEXT = Target.the("Texto de Compra Correcta").located(By.xpath("/html/body/div[10]/h2"));



}
