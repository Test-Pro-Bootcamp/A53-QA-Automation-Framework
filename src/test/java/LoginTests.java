<<<<<<< HEAD
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
=======
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
>>>>>>> upstream/main
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

<<<<<<< HEAD

public class LoginTests extends BaseTest {

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPassword(String email, String password) throws InterruptedException {

        provideEmail(email);
        providePassword(password);
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class)
    public void loginEmptyEmailPassword(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    
    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPassword(){

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        isAvatarDisplayed();
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }
    public void isAvatarDisplayed() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
}
=======
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




>>>>>>> upstream/main
