import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {


    @Test
    public void loginValidEmailPassword() {

        driver.get(url);

        //Email Field
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@class.com");
        //Password Field
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        //Submit button
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        //Assertion
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        //Quit
        driver.quit();
    }

    @Test(dataProvider="InvalidLoginData")
    public void loginWithInvalidEmailValidPassword(String email, String password) throws InterruptedException {

        navigateToUrl(url);
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Thread.sleep(2000);
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    /**
     * *Test Script using Page Object Model
     * Locators used in these test were located using By abstract class.
     */
    @Test
    public void loginWithCorrectCredentials(){

        //navigateToUrl(url);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("Andrew.Simmons@testpro.io");
        loginPage.providePassword("Andrew.Simmons24");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }


    /**
     * Login using Page Factory Elements and Fluent Interface.
     */
    @Test
    public void loginWithCorrectCredentialsUsingPageFactory() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Steps
        loginPage.provideEmailToLogin("demo@class.com")
                .providePasswordToLogin("te$t$tudent")
                .clickSubmitBtnToLogin();
        //Assertions
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

}