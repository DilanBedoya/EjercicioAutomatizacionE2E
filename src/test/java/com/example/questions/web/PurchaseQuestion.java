package com.example.questions.web;

import com.example.userinterfaces.pages.CarPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class PurchaseQuestion {
    public static Question<String> TextPurchase(){
        return actor -> TextContent.of(CarPage.PURCHASE_TEXT).answeredBy(actor);
    }
}
