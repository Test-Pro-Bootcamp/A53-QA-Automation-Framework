import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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


//        Assert.assertFalse(homePage.getUserAvatarIcon()); // Didn't work
        Assert.assertTrue(loginPage.isLoginBtnVisible()); // Didn't work


//        Assert.assertTrue(!homePage.getUserAvatarIcon().isDisplayed()); //Didn't work
//        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed()); //Didn't work

    }
}
