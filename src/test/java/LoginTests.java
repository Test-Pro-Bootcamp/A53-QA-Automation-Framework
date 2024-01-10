import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void registrationNavigation() {

        //navigateToUrl();
        provideEmail("demo@class.com");
        providePassword("wrongPassword");
        clickSubmit();

        //registrationField
        WebElement registrationLink = driver.findElement(By.cssSelector ("[href='registration']"));
        registrationLink.click();
        String registrationUrl = "https://qa.koel.app/registration";

        //Expected Results
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

    }
    @Test
    public void loginWithValidEmailPassword() {
        try {
            //navigateToUrl();
            Thread.sleep(2000);
            provideEmail("demo@class.com");
            Thread.sleep(2000);
            providePassword("te$t$tudent");
            Thread.sleep(2000);
            clickSubmit();

            //Assertion
            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } catch (Exception e) {
            System.out.println("Something went wrong." +e);
          }
    }
    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
        //navigateToUrl();
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginWithValidEmailInvalidPassword() throws InterruptedException {
        //navigateToUrl();
        provideEmail("demo@class.com");
        providePassword("wrongPassword");
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }



}



