package com.PO;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;

public class ProfilePage {

    @FindBy(how = How.XPATH,using = "//p[text()='Конструктор']")
    private SelenideElement constructorLink;

    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    @FindBy(how = How.XPATH,using = "//button[text()='Выход']")
    private SelenideElement logoutButton;

    @FindBy(how = How.XPATH,using = "(//div[@class='input__container']//div/input[@type='text'])[2]")
    private SelenideElement loginField;

    @FindBy(how = How.XPATH,using = "(//div[@class='input__container']//div/input[@type='text'])[1]")
    private SelenideElement nameField;

    @Step("Проверка наличия и заполнения полей имени и логина.")
    public void checkProfileData(String name, String email) {
        nameField.shouldHave(value(name));
        loginField.shouldHave(value(email));
    }

    @Step("Клик по меню 'Конструктор'.")
    public void clickConstructorLink() {
        constructorLink.click();
    }

    @Step("Клик по лого.")
    public void clickLogo() {
        logo.click();
    }

    @Step("Клик по кнопке 'Выход'.")
    public void logout() {
        logoutButton.click();
    }

}
