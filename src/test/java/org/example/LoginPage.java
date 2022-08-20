package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginfield;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;

    public void inputLogin(String login){
        loginfield.sendKeys(login);
    }

    public void inputPasswd(String passwd){
        loginfield.sendKeys(passwd);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }


}
