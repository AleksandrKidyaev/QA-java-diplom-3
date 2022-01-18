package com.PO;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;

public class AuthorizationPage {

    @FindBy(how = How.XPATH,using = "//div[@class='input__container']//div/input[@type='text']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = "//div[@class='input__container']//div/input[@type='password']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH,using = "//div[@class='Auth_login__3hAey']//form//button[text()='Войти']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH,using = "//a[@class='Auth_link__1fOlj'][text()='Восстановить пароль']")
    private SelenideElement restorePasswordLink;

    @FindBy(how = How.XPATH,using = "//a[@class='Auth_link__1fOlj'][text()='Зарегистрироваться']")
    private SelenideElement registerLink;

    @FindBy(how = How.XPATH,using = "//h2[text()='Вход']")
    private SelenideElement enterText;

    @Step("Заполнение полей регистрации.")
    public void inputAuthorizationData(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
    }

    @Step("Клик по кнопке 'Войти'.")
    public void clickEnterButton() {
        enterButton.click();
    }

    @Step("Клик по ссылке 'Восстановить пароль'.")
    public void clickRestorePasswordLink() {
        restorePasswordLink.click();
    }

    @Step("Клик по ссылке 'Зарегистрироваться'.")
    public void clickRegisterLink() {
        registerLink.click();
    }

    @Step("Проверка наличия текста 'Вход'.")
    public void checkEnterTextVisibility() {
        enterText.shouldBe(visible);
    }

}
