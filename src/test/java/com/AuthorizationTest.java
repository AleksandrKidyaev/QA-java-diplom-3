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

public class AuthorizationTest {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private UserOperations userOperations;
    private MainPage mainPage;
    private AuthorizationPage authorizationPage;

    @Before
    public void setUp () {
        userOperations = new UserOperations();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\karlw\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    @After
    public void tearDown () {
        userOperations.delete();
        getWebDriver().quit();
    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Авторизация")
    @Test
    @DisplayName("Авторизация пользователя по кнопке 'Войти в аккаунт'.")
    @Description("UI тест корректной авторизации нового пользователя по кнопке 'Войти в аккаунт' на главной странице.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.CRITICAL)
    public void authorizationByMainPageEnterButtonTest() {
        Map<String, String> newUser = userOperations.register();
        String email = newUser.get("email");
        String password = newUser.get("password");
        mainPage = open(URL, MainPage.class);
        mainPage.clickEnterAccountButton();
        authorizationPage = page(AuthorizationPage.class);
        authorizationPage.inputAuthorizationData(email, password);
        authorizationPage.clickEnterButton();
        mainPage.isOnMainPageAndAuthorized();
        String actualURL = url();
        Assert.assertEquals(URL, actualURL);

    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Авторизация")
    @Test
    @DisplayName("Авторизация пользователя через кнопку 'Личный Кабинет'.")
    @Description("UI тест корректной авторизации нового пользователя по кнопке 'Личный Кабинет' на главной странице.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.CRITICAL)
    public void authorizationByProfileButtonOnMainPageTest() {
        Map<String, String> newUser = userOperations.register();
        String email = newUser.get("email");
        String password = newUser.get("password");
        mainPage = open(URL, MainPage.class);
        mainPage.clickProfileLink();
        authorizationPage = page(AuthorizationPage.class);
        authorizationPage.inputAuthorizationData(email, password);
        authorizationPage.clickEnterButton();
        mainPage.isOnMainPageAndAuthorized();
    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Авторизация")
    @Test
    @DisplayName("Авторизация пользователя по ссыке из формы регистрации.")
    @Description("UI тест корректной авторизации нового пользователя по ссылке 'Войти' из формы регистрации.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.CRITICAL)
    public void authorizationByLinkFromRegistrationPageTest() {
        Map<String, String> newUser = userOperations.register();
        String email = newUser.get("email");
        String password = newUser.get("password");
        mainPage = open(URL, MainPage.class);
        mainPage.clickEnterAccountButton();
        authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRegisterLink();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickEnterLink();
        authorizationPage.inputAuthorizationData(email, password);
        authorizationPage.clickEnterButton();
        mainPage.isOnMainPageAndAuthorized();
    }

    @Epic(value = "UI Stellar Burgers")
    @Story(value = "Авторизация")
    @Test
    @DisplayName("Авторизация пользователя по ссылке из формы восстановления пароля.")
    @Description("UI тест корректной авторизации нового пользователя по ссылке 'Войти' из формы восстановления пароля.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.CRITICAL)
    public void authorizationByLinkFromPasswordRestorePageTest() {
        Map<String, String> newUser = userOperations.register();
        String email = newUser.get("email");
        String password = newUser.get("password");
        mainPage = open(URL, MainPage.class);
        mainPage.clickEnterAccountButton();
        authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRestorePasswordLink();
        RestorePasswordPage restorePasswordPage = page(RestorePasswordPage.class);
        restorePasswordPage.clickEnterLink();
        authorizationPage.inputAuthorizationData(email, password);
        authorizationPage.clickEnterButton();
        mainPage.isOnMainPageAndAuthorized();
    }

}
