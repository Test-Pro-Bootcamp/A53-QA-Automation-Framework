import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        loginPage.provideEmailToLogin("utku.aktas94@testpro.io")
                .providePasswordToLogin("ekga9uf6")
                .clickLoginButton();
      Assert.assertTrue(homePage.getUserAvatarIcon()); // I need help in this line
    }

}