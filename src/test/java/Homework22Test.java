import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import java.time.Duration;

public class Homework22Test extends BaseTest {

    WebDriver driver;
    @BeforeTest
    public void setup(){
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void registrationNavigation() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        loginPage.clickRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Assert.assertEquals(registrationPage.getActualPageUrl(), registrationPage.getPageUrl());
        endTest();
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}