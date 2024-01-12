import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //loginPage.provideEmail("john.wolschleger@testpro.io").providePassword("te$t$tudentb49").clickSubmit();
        loginPage.provideEmail("john.wolschleger@testpro.io");
        loginPage.providePassword("te$t$tudentb49");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}