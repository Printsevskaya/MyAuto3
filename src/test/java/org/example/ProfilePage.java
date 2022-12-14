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

//    @FindBy(xpath = "//*[contains(@class, 'user-account user-account_has-ticker_yes user-account_has-accent-letter_yes legouser__current-account i-bem')]")
//    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@class, 'user-account user-account_has-ticker_yes user-account_has-accent-letter_yes legouser__current-account i-bem')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/div/ul/ul/li[6]/a")
    private WebElement logoutBtn;

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'user-account__name')]")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'user-account user-account_has-subname_yes legouser__account i-bem')]")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'user-account__subname')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/div/ul/div[1]/div/span/span")));
        String userName = userMenu.getText();
        return userName; }

    public void entryMenu() {
        userMenu.click(); }
    public void userLogout() {

        logoutBtn.click(); }


}
