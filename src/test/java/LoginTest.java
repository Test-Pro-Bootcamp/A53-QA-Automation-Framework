import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void loginWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test
    public void loginWithInCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("AAutku.aktas94@testpro.io");
        loginPage.providePassword("AAekga9uf6");
        loginPage.clickSubmit();

        Assert.assertFalse(homePage.getUserAvatarIcon().isDisplayed()); // Didn't work
//        Assert.assertTrue(!homePage.getUserAvatarIcon().isDisplayed()); //Didn't work
//        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed()); //Didn't work

    }
}
