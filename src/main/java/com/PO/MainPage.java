package com.PO;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;


public class MainPage {

    @FindBy(how = How.XPATH,using = "//button[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;

    @FindBy(how = How.XPATH,using = "//p[text()='Личный Кабинет']")
    private SelenideElement profileLink;

    @FindBy(how = How.XPATH,using = "//span[text()='Булки']")
    private SelenideElement bunTab;

    @FindBy(how = How.XPATH,using = "//div[contains(@class, 'current')]/span[text()='Булки']")
    private SelenideElement selectedBunTab;

    @FindBy(how = How.XPATH,using = "//span[text()='Соусы']")
    private SelenideElement sauceTab;

    @FindBy(how = How.XPATH,using = "//div[contains(@class, 'current')]/span[text()='Соусы']")
    private SelenideElement selectedSauceTab;

    @FindBy(how = How.XPATH,using = "//span[text()='Начинки']")
    private SelenideElement fillingTab;

    @FindBy(how = How.XPATH,using = "//div[contains(@class, 'current')]/span[text()='Начинки']")
    private SelenideElement selectedFillingTab;

    @FindBy(how = How.XPATH,using = "//button[text()='Оформить заказ']")
    private SelenideElement makeOrderButton;

    @FindBy(how = How.XPATH,using = "//h1[text()='Соберите бургер']")
    private SelenideElement makeOrderMainPageText;

    @FindBy(how = How.XPATH,using = "//p[text()='Соус с шипами Антарианского плоскоходца']")
    private SelenideElement sauce;

    @FindBy(how = How.XPATH,using = "//p[text()='Говяжий метеорит (отбивная)']")
    private SelenideElement filling;

    @FindBy(how = How.XPATH,using = "//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement bun;

    @Step("Проверка наличия текста 'Соберите бургер' и кнопки 'Оформить заказ'.")
    public void isOnMainPageAndAuthorized() {
        makeOrderMainPageText.shouldBe(visible);
        makeOrderButton.shouldBe(visible, enabled);
    }

    @Step("Клик на кнопку 'Войти в аккаунт'.")
    public void clickEnterAccountButton() {
        enterAccountButton.click();
    }

    @Step("Клик на кнопку 'Личный Кабинет'.")
    public void clickProfileLink() {
        profileLink.click();
    }

    @Step("Клик на вкладку 'Булки'.")
    public void clickBunTab() {
        bunTab.click();
    }

    @Step("Клик на вкладку 'Соусы'.")
    public void clickSauceTab() {
        sauceTab.click();
    }

    @Step("Клик на вкладку 'Начинки'.")
    public void clickFillingTab() {
        fillingTab.click();
    }

    @Step("Проверка наличия соуса 'Соус с шипами Антарианского плоскоходца'.")
    public void isSauceVisible() {
        sauce.shouldBe(visible, enabled);
    }

    @Step("Проверка наличия начинки 'Говяжий метеорит (отбивная)'.")
    public void isFillingVisible() {
        filling.shouldBe(visible, enabled);
    }

    @Step("Проверка наличия булки 'Флюоресцентная булка R2-D3'.")
    public void isBunVisible() {
        bun.shouldBe(visible, enabled);
    }

    @Step("Проверка наличия выделенной вкладки 'Булки'.")
    public void isBunTabSelected() {
        selectedBunTab.shouldBe(visible);
    }

    @Step("Проверка наличия выделенной вкладки 'Начинки'.")
    public void isFillingTabSelected() {
        selectedFillingTab.shouldBe(visible);
    }

    @Step("Проверка наличия выделенной вкладки 'Соусы'.")
    public void isSauceTabSelected() {
        selectedSauceTab.shouldBe(visible);
    }

}
