import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestParallel extends BaseTest {
    @Test
    public void loginWithCorrectCredentials() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //loginPage.login();


        loginPage.provideEmail("azahn007@gmail.com");
        loginPage.providePassword("Koelpass");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }
    @Test
    public void loginWithCorrectCredentials2() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //loginPage.login();


        loginPage.provideEmail("azahn007@gmail.com");
        loginPage.providePassword("Koelpass");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }
    @Test
    public void loginWithCorrectCredentials3() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //loginPage.login();


        loginPage.provideEmail("azahn007@gmail.com");
        loginPage.providePassword("Koelpass");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }
    @Test
    public void loginWithCorrectCredentials4() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //loginPage.login();


        loginPage.provideEmail("azahn007@gmail.com");
        loginPage.providePassword("Koelpass");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }
}
