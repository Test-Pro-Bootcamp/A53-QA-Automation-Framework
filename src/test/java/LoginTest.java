import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmailToLogin("utku.aktas94@testpro.io")
                .providePasswordToLogin("ekga9uf6")
                .clickLoginButton();
      Assert.assertTrue(homePage.getUserAvatarIcon()); // I need help in this line
    }

    @Test
    public void loginInvalidEmailValidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmailToLogin("AAutku.aktas94@testpro.io")
                .providePasswordToLogin("ekga9uf6")
                .clickLoginButton();
//        Assert.assertFalse(homePage.getUserAvatarIcon()); // I need help in this line
        Assert.assertTrue(loginPage.getLoginButton()); // doesnt work
    }

}