import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void NavigateToKoelApp() {
        //navigateToUrl();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
    @Test
    public void LoginToValidEmailPassword(){
        try {
            //navigateToUrl();
            Thread.sleep(2000);
            provideEmail("demo@class.com");
            Thread.sleep(2000);
            providePassword("te$t$tudent");
            Thread.sleep(2000);
            clickSubmit();
            //Assertions
            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
            driver.quit();
        }   catch(Exception e){
            System.out.println("something went wrong." +e);

            }
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {

        //navigateToUrl();
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/

        // Post-condition
        driver.quit();
    }

    @Test
    public void loginValidEmailInvalidPassword() throws InterruptedException {

       // navigateToUrl();
        provideEmail("demo@class.com");
        providePassword("invalidPassword");
        clickSubmit();

        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/

        // Post-condition
        driver.quit();

    }


}