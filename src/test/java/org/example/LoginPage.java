package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement loginfield;
}
