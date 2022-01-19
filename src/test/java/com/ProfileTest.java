package com;
import com.PO.*;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ProfileTest {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private UserOperations userOperations;
    private MainPage mainPage;
    private AuthorizationPage authorizationPage;
    private ProfilePage profilePage;
    private String email;
    private String password;
    private String name;

    @Before
    public void setUp () {

        userOperations = new UserOperations();

        Map<String, String> newUser = userOperations.register();

        email = newUser.get("email");
        password = newUser.get("password");
        name = newUser.get("name");

        mainPage = open(URL, MainPage.class);

    }

    @After
    public void tearDown () {

        userOperations.delete();

        getWebDriver().quit();

    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Личный кабинет")
    @Test
    @DisplayName("Переход по клику в личный кабинет.")
    @Description("UI тест перехода авторизованного пользователя по клику в личный кабинет с главной страницы.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.CRITICAL)
    public void checkProfileEnteringFromMainPageTest() {

        mainPage.clickEnterAccountButton();

        authorizationPage = page(AuthorizationPage.class);

        authorizationPage.inputAuthorizationData(email, password);
        authorizationPage.clickEnterButton();
        mainPage.clickProfileLink();

        profilePage = page(ProfilePage.class);

        profilePage.checkProfileData(name, email); //Проверяем что переход в профиль осуществлен. А именно, то что имеются поля с именем и логином, в которых содержится корректная информация

    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Личный кабинет")
    @Test
    @DisplayName("Переход в конструктор по клику на кнопку 'Конструктор'.")
    @Description("UI тест перехода в конструктор авторизованного пользователя по клику на кнопку 'Конструктор' из личного кабинета.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.CRITICAL)
    public void checkClickConstructorButtonFromProfilePageTest() {

        mainPage.clickEnterAccountButton();

        authorizationPage = page(AuthorizationPage.class);

        authorizationPage.inputAuthorizationData(email, password);
        authorizationPage.clickEnterButton();
        mainPage.clickProfileLink();

        profilePage = page(ProfilePage.class);

        profilePage.clickConstructorLink();

        mainPage.isOnMainPageAndAuthorized();
        //еще была мысль проверять адрес страницы способом ниже. Но подумал, что будет избыточно, поэтому под конец решил закомментировать тут (чтобы ход мысли показать) и убрать ее из большинства остальных тестов
        //String actualURL = url();
        //Assert.assertEquals(URL, actualURL);

    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Личный кабинет")
    @Test
    @DisplayName("Переход в конструктор по клику на лого.")
    @Description("UI тест перехода в конструктор авторизованного пользователя по клику на лого из личного кабинета.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.CRITICAL)
    public void checkClickOnLogoFromProfilePageTest() {

        mainPage.clickEnterAccountButton();

        authorizationPage = page(AuthorizationPage.class);

        authorizationPage.inputAuthorizationData(email, password);
        authorizationPage.clickEnterButton();
        mainPage.clickProfileLink();

        profilePage = page(ProfilePage.class);

        profilePage.clickLogo();

        mainPage.isOnMainPageAndAuthorized();

    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Личный кабинет")
    @Test
    @DisplayName("Выход из аккаунта.")
    @Description("UI тест выхода из аккаунта авторизованного пользователя по кнопку 'Выход' в личном кабинете.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.CRITICAL)
    public void checkLogoutTest() {

        mainPage.clickEnterAccountButton();

        authorizationPage = page(AuthorizationPage.class);

        authorizationPage.inputAuthorizationData(email, password);
        authorizationPage.clickEnterButton();
        mainPage.clickProfileLink();

        profilePage = page(ProfilePage.class);

        profilePage.logout();

        authorizationPage.checkEnterTextVisibility();
        String actualURL = url();
        Assert.assertEquals(URL + "login", actualURL);

    }

}
