package com.PO;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class RegistrationPage {
    @FindBy(how = How.XPATH,using = "(//div[@class='input__container']//div/input[@type='text'])[2]")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = "(//div[@class='input__container']//div/input[@type='text'])[1]")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH,using = "//div[@class='input__container']//div/input[@type='password']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH,using = "//div[@class='Auth_login__3hAey']//form//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement enterLink;

    @FindBy(how = How.XPATH,using = "//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordControl;

    @Step("Проверка наличия контроля корректности пароля.")
    public void checkIncorrectPasswordControlVisibility() {
        incorrectPasswordControl.shouldBe(visible);
    }

    @Step("Проверка наличия кнопки 'Войти'.")
    public void isEnterLinkVisible() {
        enterLink.shouldBe(visible, enabled);
    }

    @Step("Заполнение полей регистрации.")
    public void inputRegistrationData(String email, String password, String name) {
        emailField.setValue(email);
        passwordField.setValue(password);
        nameField.setValue(name);
    }

    @Step("Клик по ссылке 'Войти'.")
    public void clickEnterLink() {
        enterLink.click();
    }

    @Step("Клик по кнопке 'Зарегистрироваться'.")
    public void clickRegisterButton() {
        registerButton.click();
    }

}
