import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void navigateToKoelApp() {
        navigateToUrl();
        //Assertion
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() {
        try {
            //Url
            navigateToUrl();

            //Email Field
            provideEmail();

            //Password Field
            providePassword();

            //Submit Button
            clickSubmit();

            WebElement avatarIcon = driver.findElement(By.cssSelector("img['class='avatar']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } catch (Exception e) {

            System.out.println("Something went wrong");
        }
    }

    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException{

        //Url
        navigateToUrl();

        //Email Field
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("VGGd8tOG");

        //Password Field
        providePassword();

        //Submit Button
        clickSubmit();

        Thread.sleep(2000);

        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}