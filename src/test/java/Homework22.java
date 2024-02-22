import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{
    @Test
    public void loginValidEmailPassword() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());
    }
}
