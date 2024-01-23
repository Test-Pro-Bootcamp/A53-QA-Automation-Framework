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

    @Test
    public void navigateToKoelApp() {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //try {
            //Thread.sleep(2000);
            provideEmail("demo@class.com");
            //Thread.sleep(2000);
            providePassword("te$t$tudent");
            //Thread.sleep(2000);
            clickSubmit();
            //Assertion
            //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
            Assert.assertTrue(avatarIcon.isDisplayed());
       // }catch (Exception e){
       //    System.out.println("Something went wrong !" +e);
       // }

    }
//
//    @Test
//    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
//        provideEmail("invalid@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        Thread.sleep(2000);
//        //Expected Result
//        Assert.assertEquals(driver.getCurrentUrl(),url);
//
//    }
//    @Test
//    public void loginWithValidEmailInvalidPassword() throws InterruptedException {
//        provideEmail("demo@class.com");
//        providePassword("invalidPassword");
//        clickSubmit();
//        Thread.sleep(2000);
//        //Expected Result
//        Assert.assertEquals(driver.getCurrentUrl(),url);
//    }
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

