import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        LoginPage login = new LoginPage(getThreadLocal());
        login.loadLoginPage();
        login.clickSubmit();
        HomePage homePage = new HomePage(getThreadLocal());
        Assert.assertFalse(homePage.avatarIsDisplayed());
    }

    @Test
    public void loginTest() {

        LoginPage login = new LoginPage(getThreadLocal());
        login.loginUsertoKoel();
        HomePage homePage = new HomePage(getThreadLocal());
        Assert.assertTrue(homePage.avatarIsDisplayed());
    }


}
