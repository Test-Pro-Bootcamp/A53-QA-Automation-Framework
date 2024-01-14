import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void navigateToKoelApp() {
        navigateToUrl();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //try{
        provideEmail("menderes.koc@testpro.io");
        providePassword("VGGd8tOG");
        clickSubmit();
        Thread.sleep(2000);
        //Assertion
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //} catch (Exception e){
        // System.out.println("Something went wrong." +e);
        //}
    }

    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
        provideEmail("invalid@class.com");
        //Password Field
        providePassword("VGGd8tOG");
        //Submit button
        clickSubmit();
        Thread.sleep(2000);
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginWithInvalidPasswordAndValidEmail() throws InterruptedException {
        //navigateToUrl();
        //Email Field
        provideEmail("menderes.koc@testpro.io");
        //Password Field
        providePassword("invalidPassword");
        //Submit button
        clickSubmit();
        Thread.sleep(2000);
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}