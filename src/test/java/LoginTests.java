import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

   /* @Parameters({"BaseUrl"})
    @Test
    public void navigateToKoelApp(String BaseUrl){
        navigateToPage(BaseUrl);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl);
        driver.quit();

    }*/

    @Test
    public void loginValidEmailPassword() throws InterruptedException {


        // navigateToPage();
        provideEmail("azahn007@gmail.com");
        providePassword("Koelpass");
        clickSubmit();
        //Thread.sleep(2000);

        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }


    @Test(dataProvider = "InvalidLoginData")
    //@Parameters({"BaseUrl"})
    public void loginWithInvalidEmailValidPassword(String email,String password) throws InterruptedException {

        provideEmail(email);
        providePassword(password);
        clickSubmit();
        //Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void loginWithInvalidPasswordValidEmail() throws InterruptedException {


        provideEmail("azahn007@gmail.com");
        providePassword("KoelpassW");
        clickSubmit();
        //Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
    //test script using Page Object Model, locators used By abstract class
    @Test
    public void loginWithCorrectCredentials(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();


       /* loginPage.provideEmail("azahn007@gmail.com");
        loginPage.providePassword("Koelpass");
        loginPage.clickSubmit();*/

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }
    @Test
    public void loginWithInCorrectCredentials(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("Pazahn007@gmail.com");
        loginPage.providePassword("Koelpass");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }
    //Login using Page Factory Elements and Fluent Interface
    @Test
    public void loginWithCorrectCredentialsUsingPageFactory(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmailToLogin("azahn007@gmail.com")
       .providePasswordToLogin("Koelpass")
        .clickSubmitBtnToLogin();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }

}








