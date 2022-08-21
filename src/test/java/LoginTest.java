import org.example.ConfProperties;
import org.example.LoginPage;
import org.example.ProfilePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    @BeforeClass
    public static void setup(){
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\julia\\OneDrive\\ChromeDriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.get("http://passport.yandex.ru/auth");
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver = new ChromeDriver();
    }

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;


    @Test
    public void loginTest(){

    }


}
