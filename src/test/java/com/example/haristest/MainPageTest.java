package com.example.haristest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.headless = true;
        Configuration.timeout = 60;
    }

    @Test
    public void seeAllInvoices(){
        open("http://103.4.11.138:42069/");
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/button[2]")).click();
    }

    @Test
    public void seeSpecificInvoice() throws InterruptedException {
        open("http://103.4.11.138:42069/");
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/button[2]")).click();

        ElementsCollection elements  = $$("div.container > .row");

        System.out.println(elements.size());

        if(elements.size() > 1){
            System.out.println("Clicked");
            $(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[3]/div/button[2]")).click();
        }
        else{
            System.out.println("Not clicked");
        }
    }


    @Test
    public void createAnInvoice() {
        open("http://103.4.11.138:42069/");
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/button[1]")).click();

        $(By.name("invoiceDesc")).setValue("Test Description");
        $(By.name("sellerName")).setValue("Test Name");
        $(By.name("sellerAddress")).setValue("Test Address");
        $(By.name("customerName")).setValue("Test Name");
        $(By.name("customerAddress")).setValue("Test Address");
        $(By.name("productDesc")).setValue("Test Description");
        $(By.name("productPrice")).setValue("200");
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div[3]/button")).click();

        $(By.name("termAndCon")).setValue("Test Term and Conditions");

        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[6]/div/div/div/button")).click();
    }

    @Test
    public void updateAnInvoice(){
        createAnInvoice();


        open("http://103.4.11.138:42069/");
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/button[2]")).click();

        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[3]/div/button[3]")).click();

        $(By.name("invoiceDesc")).setValue("Test2 Description");
        $(By.name("sellerName")).setValue("Test2 Name");
        $(By.name("sellerAddress")).setValue("Test2 Address");
        $(By.name("customerName")).setValue("Test2 Name");
        $(By.name("customerAddress")).setValue("Test2 Address");
        $(By.name("productDesc")).setValue("Test2 Description");
        $(By.name("productPrice")).setValue("200");
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div[3]/button")).click();

        $(By.name("termAndCon")).setValue("Test Term and Conditions");

        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[6]/div/div/div/div/button[1]")).click();

        $(By.xpath("/html/body/div[3]/div/div/div[3]/button")).click();

        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[6]/div/div/div/div/button[2]")).click();
    }


    @Test
    public void deleteAnInvoice(){

        createAnInvoice();

        open("http://103.4.11.138:42069/");
        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/button[2]")).click();

        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[3]/div/button[1]")).click();

        $(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[3]/div/button[1]")).click();
    }

}
