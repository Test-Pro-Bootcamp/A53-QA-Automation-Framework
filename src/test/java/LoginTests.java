import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void navigateToKoelApp() {
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "http://qa.koel.app/";*/
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
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



