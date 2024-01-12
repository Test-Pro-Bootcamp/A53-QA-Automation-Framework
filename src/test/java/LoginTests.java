import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
   /* @Parameters({"BaseUrl"})
    @Test
    public void navigateToKoelApp(String BaseUrl){
        navigateToPage(BaseUrl);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl);
        driver.quit();

    }*/

    @Test
    public void loginValidEmailPassword() throws InterruptedException {


        // navigateToPage();
        provideEmail("azahn007@gmail.com");
        providePassword("Koelpass");
        clickSubmit();
        //Thread.sleep(2000);

        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }


    @Test(dataProvider = "InvalidLoginData")
    //@Parameters({"BaseUrl"})
    public void loginWithInvalidEmailValidPassword(String email,String password) throws InterruptedException {

        provideEmail(email);
        providePassword(password);
        clickSubmit();
        //Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void loginWithInvalidPasswordValidEmail() throws InterruptedException {


        provideEmail("azahn007@gmail.com");
        providePassword("KoelpassW");
        clickSubmit();
        //Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), url);




    }
}








