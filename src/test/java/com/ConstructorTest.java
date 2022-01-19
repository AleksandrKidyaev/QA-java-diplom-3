package com;
import com.PO.*;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ConstructorTest {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @After
    public void tearDown() {
        getWebDriver().quit();
    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Конструктор")
    @Test
    @DisplayName("Переключение вкладок конструктора.")
    @Description("UI тест корректности переключения вкладок конструктора.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.NORMAL)
    public void checkConstructorTabsSwitchTest() {

        MainPage mainPage = open(URL, MainPage.class);

        mainPage.clickFillingTab();
        mainPage.isFillingTabSelected();
        mainPage.isFillingVisible();
        mainPage.clickBunTab();
        mainPage.isBunTabSelected();
        mainPage.isBunVisible();
        mainPage.clickSauceTab();

        mainPage.isSauceTabSelected();
        mainPage.isSauceVisible();

    }

}
