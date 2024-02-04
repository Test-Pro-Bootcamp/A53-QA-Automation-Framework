import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTests extends BaseTest {
    @Test
    public void navigateToKoelApp() {
        navigateToPage();


        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }


    @Test
    public void loginValidEmailPassword() {
        try {
            provideEmail("dmitry.lobachev@testpro.io");
            providePassword("Chebyreki5!");
            clickSubmit();
            //Assertion
            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));


            Assert.assertTrue(avatarIcon.isDisplayed());
        } catch (Exception e) {
            System.out.println("Something went wrong." + e);
            Assert.fail("Something went wrong." + e);
        }
    }
}