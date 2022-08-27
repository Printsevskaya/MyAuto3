package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProfilePage {

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора меню пользователя
     */
//    @FindBy(xpath = "//*[contains(@class, 'account__name_hasAccentLetter')]")
    @FindBy(xpath = "//*[contains(@class, 'user-pic__image')]")
    private WebElement userMenu;
    /**
     * определение локатора кнопки выхода из аккаунта
     */
//    @FindBy(xpath = "//*[contains(@class, 'menu-item_action_exit menu__item menu__item_type_link')]"
    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_exit\" data-bem=')]")
    private WebElement logoutBtn;
    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'account__name_hasAccentLetter')]")));
        String userName = userMenu.getText();
        return userName; }
    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void entryMenu() {
        userMenu.click(); }
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logoutBtn.click(); }


}
