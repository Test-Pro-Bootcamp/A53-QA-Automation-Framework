import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class
LoginTests extends BaseTest {

//    @Test
//    public void navigateToKoelApp() {
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }

//    @Test
//    public void loginValidEmailPassword() throws InterruptedException {
//        //try {
//            //Thread.sleep(2000);
//            provideEmail("demo@class.com");
//            //Thread.sleep(2000);
//            providePassword("te$t$tudent");
//            //Thread.sleep(2000);
//            clickSubmit();
//            //Assertion
//            //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
//            WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
//            Assert.assertTrue(avatarIcon.isDisplayed());
//       // }catch (Exception e){
//       //    System.out.println("Something went wrong !" +e);
//       // }
//
//    }
    @Test(priority = 0) //Smoke test
    public void loginWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
//        LoginPage loginPage = new LoginPage(driver2);
//        HomePage homePage = new HomePage(driver2);

        loginPage.login();
        //Assert
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
    @Test(priority = 1)
    public void loginWithCorrectCredentials2(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        //Assert
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }


    @Test(priority = 2)
    public void loginWithInvalidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmailToLogin("demo@class111.com")
                .providePasswordToLogin("te$t$tudent")
                .clickSubmitToLogin();
        //Assert
        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }
    @Test(priority = 3)
    public void loginWithValidEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmailToLogin("demo@class.com")
                .providePasswordToLogin("te$t$tudent111")
                .clickSubmitToLogin();
        //Assert
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
    @Test(priority = 4)
    public void loginWithInvalidEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmailToLogin("demo@class111.com")
                .providePasswordToLogin("te$t$tudent111")
                .clickSubmitToLogin();
        //Assert
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
//
//    /*
//     * Login Using Page Factory Elements and Fluent Interface
//     */
//    @Test
//    public void loginWithCorrectCredentialsUsingPageFactory(){
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//        //Steps
////        loginPage.provideEmailToLogin("demo@class.com");
////        loginPage.providePasswordToLogin("te$t$tudent");
////        loginPage.clickSubmitToLogin();
//        loginPage.provideEmailToLogin("demo@class.com")
//                .providePasswordToLogin("te$t$tudent")
//                .clickSubmitToLogin();
//        //Assert
//        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
//    }

}

