import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }

    @Test
    public void loginWithInvalidPasswordAndValidEmail() {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            loginPage.provideEmail("demo@class.com");
            loginPage.providePassword("invalid password");
            loginPage.clickSubmit();
            Assert.assertEquals(driver.getCurrentUrl(), url);

        }

//    @Test(dataProvider = "InvalidLoginData", dataProviderClass=BaseTest.class)
//    //@Parameters({"BaseUrl"})
//    public void loginWithInvalidEmailValidPassword(String email, String password) throws InterruptedException {
//        provideEmail(email);
//        //Password Field
//        providePassword(password);
//        //Submit button
//        clickSubmit();
//        //Thread.sleep(2000);
//        //Expected Result
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }
//
//    /*@Test
//    public void loginWithInvalidPasswordAndValidEmail() throws InterruptedException {
//        //navigateToUrl();
//        //Email Field
//        provideEmail("demo@class.com");
//        //Password Field
//        providePassword("invalidPassword");
//        //Submit button
//        clickSubmit();
//        Thread.sleep(2000);
//        //Expected Result
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }*/
//
//
//    /**
//     * Test Script using Page Object Model.
//     * Locators used in these test were located using By abstract class.
//     */
//    @Test
//    public void loginWithCorrectCredentials(){
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//        loginPage.login();
//
//        /*loginPage.provideEmail("demo@class.com");
//        loginPage.providePassword("te$t$tudent");
//        loginPage.clickSubmit();*/
//
//        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
//    }
//
//    @Test
//    public void loginWithInCorrectCredentials(){
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//
//        loginPage.provideEmail("demo1@class.com");
//        loginPage.providePassword("test$tudent");
//        loginPage.clickSubmit();
//
//        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
//    }
//
//    /**
//     * Login using Page Factory Elements and Fluent Interface.
//     */
//    @Test
//    public void loginWithCorrectCredentialsUsingPageFactory() {
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//        //Steps
//        loginPage.provideEmailToLogin("demo@class.com")
//                .providePasswordToLogin("te$t$tudent")
//                .clickSubmitBtnToLogin();
//        //Assertions
//        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
//    }


}




