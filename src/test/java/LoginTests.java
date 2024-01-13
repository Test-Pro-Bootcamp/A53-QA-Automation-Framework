import org.openqa.selenium.By;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
>>>>>>> 324cfc13c21ee3b493b7005b1f765181e2eab0fc
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void navigateToKoelApp() {
        navigateToUrl();
<<<<<<< HEAD
        //Assertion
=======

>>>>>>> 324cfc13c21ee3b493b7005b1f765181e2eab0fc
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();

    }
<<<<<<< HEAD

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
=======
    @Test
    public void loginValidEmailPassword() {
        try {
            provideEmail("menderes.koc@testpro.io");
            Thread.sleep(2000);
            providePassword("VGGd8tOG");
            clickSubmit();

            //Assertion
            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatarIcon.isDisplayed());

        } catch (Exception e) {
            System.out.println("Something went wrong." + e);
        }
    }
    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {

        //Email Field
        provideEmail("invalid@class.com");

        //Password Field
        providePassword("VGGd8tOG");

        //Submit button
        clickSubmit();
        Thread.sleep(2000);

        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    };

    @Test
    public void loginWithInvalidPasswordAndValidEmail() throws InterruptedException {

        //Email Field
        provideEmail("menderes.koc@testpro.io");

        //Password Field
        providePassword("invalidPassword");
>>>>>>> 324cfc13c21ee3b493b7005b1f765181e2eab0fc

        //Submit Button
        clickSubmit();

        Thread.sleep(2000);
<<<<<<< HEAD

        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
=======
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

}



>>>>>>> 324cfc13c21ee3b493b7005b1f765181e2eab0fc
