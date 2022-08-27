import junit.framework.Assert;
import org.example.ConfProperties;
import org.example.LoginPage;
import org.example.ProfilePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\julia\\OneDrive\\ChromeDriver");
       // System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://passport.yandex.ru/auth");
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        //driver = new ChromeDriver();
    }

//    public static LoginPage loginPage;
//    public static ProfilePage profilePage;
//    public static WebDriver driver;


    @Test
    public void loginTest(){
        //значение login/password берутся из файла настроек по аналогии с chromedriver
//и loginpage
//вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }


    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit(); }

}
