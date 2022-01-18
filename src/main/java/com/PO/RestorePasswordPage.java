package com.PO;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePasswordPage {

    @FindBy(how = How.XPATH,using = "//a[@class='Auth_link__1fOlj'][text()='Войти']")
    private SelenideElement enterLink;

    @Step("Клик по ссылке 'Войти'.")
    public void clickEnterLink() {
        enterLink.click();
    }

}
