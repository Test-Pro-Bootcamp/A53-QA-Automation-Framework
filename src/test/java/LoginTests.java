import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class
LoginTests extends BaseTest {

    @Test
    public void navigateToKoelApp() {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword(){
        try {
            Thread.sleep(2000);
            provideEmail("demo@class.com");
            Thread.sleep(2000);
            providePassword("te$t$tudent");
            Thread.sleep(2000);
            clickSubmit();
            //Assertion
            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        }catch (Exception e){
            System.out.println("Something went wrong !" +e);
        }

    }

    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);

    }
    @Test
    public void loginWithValidEmailInvalidPassword() throws InterruptedException {
        provideEmail("demo@class.com");
        providePassword("invalidPassword");
        clickSubmit();
        Thread.sleep(2000);
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

}

