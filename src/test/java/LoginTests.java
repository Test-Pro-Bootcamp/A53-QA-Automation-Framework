import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    // @Test
    //public void navigateToKoelApp() {
    //navigateToPage();


    //    Assert.assertEquals(driver.getCurrentUrl(), url);
    //    driver.quit();
    // }


    // @Test
    //public void loginValidEmailPassword() {
    //  try {
    // provideEmail("dmitry.lobachev@testpro.io");
    //   providePassword("Chebyreki5!");
    //   clickSubmit();
    //Assertion
    //  WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

    //  Assert.assertTrue(avatarIcon.isDisplayed());
    //    }catch (Exception e){
    //   System.out.println("Something went wrong !" +e);
// }

    @Test
    public void loginWithCorrectCredentials() {
        LoginPage loginPage = new LoginPage (getDriver());
        HomePage homePage = new HomePage(getDriver());
//        LoginPage loginPage = new LoginPage(driver2);
//        HomePage homePage = new HomePage(driver2);

        loginPage.login();
        //Assert
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test
    public void loginWithCorrectCredentials2() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        //Assert
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test
    public void loginWithCorrectCredentials3() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        //Assert
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test
    public void loginWithCorrectCredentials4() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        //Assert
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
}