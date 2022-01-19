package com;
import com.PO.*;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class RegistrationTest {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private UserOperations userOperations;
    private MainPage mainPage;
    private AuthorizationPage authorizationPage;
    private RegistrationPage registrationPage;
    private String email;
    private String name;

    @Before
    public void setUp () {

        userOperations = new UserOperations();

        mainPage = open(URL, MainPage.class);
        mainPage.clickEnterAccountButton();
        authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRegisterLink();
        registrationPage = page(RegistrationPage.class);

        email = userOperations.getRandomEmail();
        name = userOperations.getRandomName();

    }

    @After
    public void tearDown () {
        getWebDriver().quit();
    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Регистрация")
    @Test
    @DisplayName("Успешная регистрация нового пользователя.")
    @Description("UI тест корректной регистрации нового пользователя с его последующим удалением.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.BLOCKER)
    public void correctRegistrationTest() {

        String password = userOperations.getRandomPassword();

        registrationPage.inputRegistrationData(email, password, name);
        registrationPage.clickRegisterButton();
        userOperations.setTokens(email, password);
        authorizationPage.inputAuthorizationData(email, password);
        authorizationPage.clickEnterButton();

        mainPage.isOnMainPageAndAuthorized(); //Проверяем, что авторизация была успешна, т.е. пользователь оказался на главной странице и кнопка "Оформить заказ" доступна

        userOperations.delete();
    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Регистрация")
    @Test
    @DisplayName("Регистрация пользователя с некорректным паролем.")
    @Description("UI тест регистрации нового пользователя с вводом пароля менее шести символов.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.NORMAL)
    public void registrationWithIncorrectPasswordTest() {

        String password = userOperations.getRandomIncorrectPassword();

        registrationPage.inputRegistrationData(email, password, name);
        registrationPage.checkIncorrectPasswordControlVisibility(); //проверяем появился ли контроль на некорректность пароля
        registrationPage.clickRegisterButton(); //пробуем зарегистрироваться не смотря на контроль

        String actualURL = url();
        Assert.assertEquals(URL + "register", actualURL); //подтверждаем, что регистрация с некорректным паролем не прошла и пользователь все еще находится на странице регистрации
        registrationPage.isEnterLinkVisible(); //и доступна ссылка "Войти"

    }

}
