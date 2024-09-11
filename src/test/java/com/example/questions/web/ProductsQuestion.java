package com.example.questions.web;

import com.example.userinterfaces.pages.CarPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class ProductsQuestion {

    public static Question<String> titleProducts1(){
        return actor -> TextContent.of(CarPage.PRODUCT_1_TEXT).answeredBy(actor);
    }

    public static Question<String> titleProducts2(){
        return actor -> TextContent.of(CarPage.PRODUCT_2_TEXT).answeredBy(actor);
    }

}
