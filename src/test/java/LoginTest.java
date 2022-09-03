import junit.framework.Assert;
import org.example.ConfProperties;
import org.example.LoginPage;
import org.example.ProfilePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://passport.yandex.ru/auth");
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

    }

    @Test
    public void loginTest() throws InterruptedException {

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Thread.sleep(10000);
        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }

    @AfterAll
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit(); }

}
