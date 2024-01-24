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

    @Test
    public void registrationNavigation() {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loadLoginPage();
        loginPage.clickRegistration();
        RegistrationPage registrationPage = new RegistrationPage(getThreadLocal());
        Assert.assertEquals(registrationPage.getActualPageUrl(), registrationPage.getPageUrl());
    }

}