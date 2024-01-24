import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest{

//    LoginPage loginPage = new LoginPage(driver);
//     HomePage homePage = new HomePage(driver);
    @Test
    public void loginWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
//        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
        Assert.assertTrue(homePage.getUserAvatarIcon());
    }

    @Test
    public void loginWithInCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("AAutku.aktas94@testpro.io");
        loginPage.providePassword("AAekga9uf6");
        loginPage.clickSubmit();

//        Assert.assertTrue(loginPage.isLoginBtnVisible()); // Login Button Approach

        boolean isAvatarNotVisible = waitForInvisibilityOfElement(By.cssSelector("img.avatar"), 2);
        Assert.assertTrue(isAvatarNotVisible,"User avatar icon should not be displayed after incorrect login");
    }

    private boolean waitForInvisibilityOfElement(By locator, int timeoutInSeconds){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }catch (Exception e){
            return false;
        }
    }
}